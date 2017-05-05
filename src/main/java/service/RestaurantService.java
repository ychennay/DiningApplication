package main.java.service;

import main.java.model.Restaurant;
import main.java.model.Review;

/**
 * Created by ychen4 on 5/4/2017.
 */
public interface RestaurantService {

    Iterable<Review> listAllRestaurants();

    Restaurant getRestaurantById(int id);

    Restaurant saveRestaurant(Restaurant restaurant);

    Restaurant updateRestaurant(int id);

    Restaurant deleteRestaurant(int id);

}
