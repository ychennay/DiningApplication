package main.java.batch.readers;

import main.java.config.PropertyConfiguration;
import main.java.implementations.YelpServiceImplementation;
import main.java.model.Restaurant;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ychen4 on 6/8/2017.
 */
public class CustomYelpFusionReader implements ItemReader<Restaurant> {


    private List<Restaurant> restaurantData;
    private int maxCapacity =100;
    private YelpServiceImplementation yelpServiceImplementation = new YelpServiceImplementation();
    Logger logger = Logger.getLogger(this.getClass());
    private PropertyConfiguration configurations;
    private int restaurantCount = 0;


    @Override
    public Restaurant read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (restaurantDataNotInitialized()){
            this.restaurantData = fetchRestaurantDataFromAPI();
        }
       if (restaurantCount < this.restaurantData.size()){
            logger.info("\nIncrementing...\n");
            return restaurantData.get(restaurantCount++);
       }
        return null;
    }

    private boolean restaurantDataNotInitialized(){
        return this.restaurantData == null;
    }
    

    public List<Restaurant> fetchRestaurantDataFromAPI() throws MalformedURLException, JSONException {
        List<Restaurant> restaurantList = new ArrayList<>();
        JSONObject restaurantJson = yelpServiceImplementation.retrieveAllRestaurantsJson();
        JSONArray businesses = (JSONArray) restaurantJson.get("businesses");
        logger.info("\n\n SIZE: " + businesses.length());

        int capacity = (businesses.length() < maxCapacity) ? businesses.length() : maxCapacity;
        for (int i = 0; i < capacity; i++){
            JSONObject business = (JSONObject) businesses.get(i);
            Restaurant restaurant = new Restaurant();
            restaurant.setRating((float) Double.doubleToRawLongBits((double) business.get("rating")));
            restaurant.setImageUrl((String) business.get("image_url"));
            restaurant.setReviewCount((Integer) business.get("review_count"));
            restaurant.setName((String) business.get("name"));
            restaurant.setPhone((String) business.get("phone"));
            restaurant.setCity((String) business.getJSONObject("location").get("city"));
            restaurant.setPostalCode((String) business.getJSONObject("location").get("zip_code"));
            restaurant.setRestaurantId(((String) business.get("id")));
            restaurant.setIsClosed((String.valueOf(business.get("is_closed"))));
            restaurant.setLatitude((float) Double.doubleToRawLongBits((double)business.
                    getJSONObject("coordinates").get("latitude")));
            restaurant.setLongitude((float) Double.doubleToRawLongBits((double)business.
                    getJSONObject("coordinates").get("longitude")));
            restaurantList.add(restaurant);

        }

        return restaurantList;
    }

    public void setConfigurations(PropertyConfiguration configurations) throws MalformedURLException, JSONException {
        this.configurations = configurations;
        this.maxCapacity = 100;
        this.restaurantData = fetchRestaurantDataFromAPI();
    }

    public PropertyConfiguration getConfigurations() {
        return configurations;
    }
}