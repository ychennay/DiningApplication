package main.java.service;

import main.java.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant getRestaurantById(String restaurantId);

    List<Restaurant> randomFiveRestaurants(String city);

    List<Restaurant> randomFiveRestaurants(String city, String label);

    Restaurant updateRestaurantById(String restaurantId);

}
