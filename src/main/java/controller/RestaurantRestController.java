package main.java.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import main.java.model.Restaurant;
import main.java.service.RestaurantService;
import main.java.service.RestaurantServiceImplementation;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ychen4 on 4/30/2017.
 */
@RestController
public class RestaurantRestController extends GenericRestController{

    private RestaurantServiceImplementation restaurantService;

    @Autowired
    public RestaurantRestController(RestaurantServiceImplementation restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/api/restaurant/{restaurantId}")
    public Restaurant getRestaurantById(@PathVariable("restaurantId") String restaurantId) throws Exception {
        return restaurantService.getRestaurantById(restaurantId);
    }

    @GetMapping("/api/restaurant/city/{city}")
    public List<Restaurant> getRestaurantsByCity(@PathVariable("city") String city) throws Exception {
        return restaurantService.randomFiveRestaurants(city);
    }

    @GetMapping("/api/restaurant/city/{city}/label/{label}")
    public List<Restaurant> getRestaurantsByCityLabel(@PathVariable("city") String city, @PathVariable("label") String label)
        throws Exception {
        return restaurantService.randomFiveRestaurants(city, label);
    }

//    @GetMapping("/api/restaurants")
//    public String getRestaurants() {
//        return "Here would appear a list of restaurants";
//    }

//    @GetMapping("api/restaurantcreate")
//    public String getRestaurant(){
//        Restaurant restaurant = new Restaurant();
//        restaurant.setId(2);
//        restaurant.setName("Il Tram");
//        System.out.println("restaurante");
//        DynamoClientMapper dynamoClientMapper = new DynamoClientMapper();
//        dynamoClientMapper.getMapper().save(restaurant);
//        return restaurant.toString();
//    }
}
