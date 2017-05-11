package main.java.service;


import main.java.model.Restaurant;
import main.java.model.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ychen4 on 4/30/2017.
 */

@Component
public class RestaurantServiceImplementation implements RestaurantService {

    private static List<Restaurant> restaurants;
    {
        restaurants = new ArrayList();

    }

    public List listAllRestaurants(){
        return restaurants;
    }

//    @Override
//    public Restaurant getRestaurantById(int id){
//        for (Restaurant r: restaurants){
//            if (r.getId() == id){
//                return r;
//            }
//        }
//    return null;
//    }
//
//    public Restaurant saveRestaurant(Restaurant restaurant){
//        restaurant.setId((int)Math.random());
//        restaurants.add(restaurant);
//        return restaurant;
//    }

//    @Override
//    public Restaurant updateRestaurant(int id) {
//        return null;
//    }
//
//    @Override
//    public Restaurant deleteRestaurant(int id) {
//        return null;
//    }
}
