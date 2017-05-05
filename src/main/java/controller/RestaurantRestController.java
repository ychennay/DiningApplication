package main.java.controller;

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

    @GetMapping("/restaurants")
    public String getRestaurants() {
        return "Here would appear a list of restaurants";}

}
