package main.java.controller;

import main.java.App;
import main.java.implementations.YelpServiceImplementation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;

/**
 * Created by ychen4 on 5/26/2017.
 */
@RestController
public class YelpFusionApiController extends GenericRestController {

    private static final Logger logger = Logger.getLogger(App.class.toString());
    private YelpServiceImplementation yelpServiceImplementation;

    @Autowired
    public void yelpFusionApiController(YelpServiceImplementation yelpServiceImplementation){
        this.yelpServiceImplementation = yelpServiceImplementation;
    }

    @RequestMapping(value = "/yelp/search/", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String searchForRestaurant(@RequestParam("name") String name) throws MalformedURLException {
        return yelpServiceImplementation.retrieveRestaurant(name);
    }

}
