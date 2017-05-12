package main.java.service;

import main.java.model.Restaurant;

import java.util.List;

/**
 * Created by ychen4 on 5/4/2017.
 */
public interface RestaurantService {

    Restaurant getRestaurantById(String restaurantId);

    List<Restaurant> randomFiveRestaurants(String city);

    List<Restaurant> randomFiveRestaurants(String city, String label);

//    List<Restaurant> listAllRestaurants();
//
//    void setRestaurantList(List<Restaurant> restaurantList);
//
//    Restaurant searchIndex(int index);

//    Restaurant getRestaurantById(String id);
//
//    Restaurant saveRestaurant(Restaurant restaurant);
//
//    Restaurant updateRestaurant(int id);
//
//    Restaurant deleteRestaurant(int id);

}
