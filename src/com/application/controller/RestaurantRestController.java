package com.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ychen4 on 4/30/2017.
 */
@RestController
public class RestaurantRestController {

    @GetMapping("/restaurants")
    public String getRestaurants() {
        return "Here would appear a list of restaurants";}

}
