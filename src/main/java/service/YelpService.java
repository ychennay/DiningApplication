package main.java.service;

import org.springframework.http.HttpStatus;

import java.io.IOException;

/**
 * Created by ychen4 on 5/16/2017.
 */
public interface YelpService {

    String retrieveAllRestaurants();

    String retrieveRestaurant(String restaurantName);

    HttpStatus generateAccessToken() throws IOException;
}
