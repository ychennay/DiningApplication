package main.java.service;

import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by ychen4 on 5/16/2017.
 */
public interface YelpService {

    String retrieveAllRestaurants();

    String retrieveRestaurants(String restaurantName) throws MalformedURLException;

    HttpStatus generateAccessToken() throws IOException;
}
