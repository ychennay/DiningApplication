package main.java.batch.readers;

import main.java.config.PropertyConfiguration;
import main.java.implementations.YelpServiceImplementation;
import main.java.model.Restaurant;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ychen4 on 6/8/2017.
 */
public class CustomYelpFusionReader implements ItemReader<Restaurant> {

    private List<Restaurant> restaurantData;
    private YelpServiceImplementation yelpServiceImplementation = new YelpServiceImplementation();
    int restaurantIndex;
    Logger logger = Logger.getLogger(this.getClass());


    @Override
    public Restaurant read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (restaurantDataNotInitialized()){
        }
        return null;
    }

    private boolean restaurantDataNotInitialized(){
        return this.restaurantData == null;
    }

    private List<Restaurant> fetchRestaurantDataFromAPI() throws MalformedURLException {
        JSONObject restaurantJson = yelpServiceImplementation.retrieveAllRestaurantsJson();
        for (Iterator key = restaurantJson.keys(); key.hasNext();){
            logger.info(key);
        }
        logger.info(restaurantJson);
        return null;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args){

        String configFile = "configuration.xml";
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext(configFile);
        PropertyConfiguration configuration = (PropertyConfiguration) context.getBean("propertyConfiguration");
        CustomYelpFusionReader reader = new CustomYelpFusionReader();
        try {
            reader.fetchRestaurantDataFromAPI();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}