package main.java.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import main.java.dao.DynamoClientMapper;
import main.java.model.Restaurant;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by ychen4 on 4/30/2017.
 */

@Component
public class RestaurantServiceImplementation implements RestaurantService {

    private Map<String, Restaurant> restaurantMap;
    private Map<String, List<String>> cityMap;
    private Map<String, Map<String, List<String>>> cityLabelMap;
    private static Logger logger = Logger.getLogger(RestaurantServiceImplementation.class.getName());

    private DynamoClientMapper dynamoClientMapper;

    @Autowired
    public RestaurantServiceImplementation(DynamoClientMapper dynamoClientMapper) {
        logger.info("RestaurantServiceImplementation initialized");
        this.dynamoClientMapper = dynamoClientMapper;
        restaurantMap = this.dynamoClientMapper.getRestaurantMap();
        cityMap = this.dynamoClientMapper.getCityMap();
        cityLabelMap = this.dynamoClientMapper.getCityLabelMap();
    }

    public Restaurant getRestaurantById(String restaurantId){
        logger.info("getRestaurantById method called");
        return restaurantMap.get(restaurantId);
    }

    public List<Restaurant> randomFiveRestaurants(String city) {
        List<Restaurant> restaurantList = new LinkedList<>();
        List<String> restaurantIdList = cityMap.get(city);

        try {
            List<String> checkDuplicateList = new LinkedList<>();
            Random randomizer = new Random();
            while(restaurantList.size() < 5) {
                String restaurantId = restaurantIdList.get(randomizer.nextInt(restaurantIdList.size()));
                if (!checkDuplicateList.contains(restaurantId)) {
                    checkDuplicateList.add(restaurantId);
                    restaurantList.add(restaurantMap.get(restaurantId));
                }
            }
        } catch (Exception e) {
            System.err.println("Unable to retrieve random five restaurants:");
            System.err.println(e.getMessage());
        }

        return restaurantList;
    }

    public List<Restaurant> randomFiveRestaurants(String city, String label) {
        List<Restaurant> restaurantList = new LinkedList<>();
        List<String> restaurantIdList = cityLabelMap.get(city).get(label);

        try {
            List<String> checkDuplicateList = new LinkedList<>();
            Random randomizer = new Random();
            while(restaurantList.size() < 5) {
                String restaurantId = restaurantIdList.get(randomizer.nextInt(restaurantIdList.size()));
                if (!checkDuplicateList.contains(restaurantId)) {
                    checkDuplicateList.add(restaurantId);
                    restaurantList.add(restaurantMap.get(restaurantId));
                }
            }
        } catch (Exception e) {
            System.err.println("Unable to retrieve random five restaurants:");
            System.err.println(e.getMessage());
        }

        return restaurantList;
    }

    @Override
    public Restaurant updateRestaurantById(String restaurantId) {
        return null;
    }
}
