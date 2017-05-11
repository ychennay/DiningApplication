package main.java.service;

import main.java.model.Restaurant;
import main.java.model.Review;

import java.util.List;

/**
 * Created by ychen4 on 5/4/2017.
 */
public interface RestaurantService {

    List<Restaurant> listAllRestaurants();

    void setRestaurantList(List<Restaurant> restaurantList);

    Restaurant searchIndex(int index);

//    Restaurant getRestaurantById(String id);
//
//    Restaurant saveRestaurant(Restaurant restaurant);
//
//    Restaurant updateRestaurant(int id);
//
//    Restaurant deleteRestaurant(int id);

}
