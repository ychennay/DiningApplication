package main.java.service;

import main.java.model.Restaurant;
import main.java.model.Review;

import java.util.List;

/**
 * Created by ychen4 on 5/4/2017.
 */
public interface RestaurantService {

    List<Restaurant> listAllRestaurants();

    Restaurant getRestaurantById(int id);

    Restaurant saveRestaurant(Restaurant restaurant);

    Restaurant updateRestaurant(int id);

    Restaurant deleteRestaurant(int id);

}
