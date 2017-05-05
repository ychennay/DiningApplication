package main.java.service;


import main.java.model.Restaurant;
import main.java.model.Review;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ychen4 on 4/30/2017.
 */

@Component
public class RestaurantDao {

    private static List<Restaurant> restaurants;
    {
        restaurants = new ArrayList();

    }

    public List list(){
        return restaurants;
    }

    public Restaurant get(int id){
        for (Restaurant r: restaurants){
            if (r.getId() == id){
                return r;
            }
        }
    return null;
    }

    public Restaurant create(Restaurant restaurant){
        restaurant.setId((int)Math.random());
        restaurants.add(restaurant);
        return restaurant;
    }
}
