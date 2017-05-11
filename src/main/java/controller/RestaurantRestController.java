package main.java.controller;

import main.java.dao.DynamoClientMapper;
import main.java.model.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ychen4 on 4/30/2017.
 */
@RestController
public class RestaurantRestController extends GenericRestController{

//    @GetMapping("/api/restaurants")
//    public String getRestaurants() {
//        return "Here would appear a list of restaurants";
//    }
//
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
