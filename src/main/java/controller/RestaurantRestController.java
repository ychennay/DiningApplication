package main.java.controller;

import main.java.implementations.YelpServiceImplementation;
import main.java.model.Restaurant;
import main.java.implementations.RestaurantServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by ychen4 on 4/30/2017.
 */
@RestController
public class RestaurantRestController extends GenericRestController{

    private RestaurantServiceImplementation restaurantService;
    private YelpServiceImplementation yelpService;

    @Autowired
    public RestaurantRestController(RestaurantServiceImplementation restaurantService, YelpServiceImplementation yelpService) {
        this.restaurantService = restaurantService;
        this.yelpService = yelpService;
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

    @GetMapping("/yelp")
    public HttpStatus getAccessToken() throws IOException {
        return yelpService.generateAccessToken();
    }


}
