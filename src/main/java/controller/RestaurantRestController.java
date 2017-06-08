package main.java.controller;

import main.java.implementations.YelpServiceImplementation;
import main.java.model.Restaurant;
import main.java.implementations.RestaurantServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.Path;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by ychen4 on 4/30/2017.
 */
@RestController
public class RestaurantRestController extends GenericRestController{

    private RestaurantServiceImplementation restaurantService;
    private YelpServiceImplementation yelpService;

    private String accountService = "ACCOUNT";
    private String accountServicePath = "/ws-account/api";

    @Autowired
    DiscoveryClient client;

    @Autowired
    public RestaurantRestController(RestaurantServiceImplementation restaurantService, YelpServiceImplementation yelpService) {
        this.restaurantService = restaurantService;
        this.yelpService = yelpService;
    }

    @RequestMapping("/restaurant/{restaurantId}/user/{userId}")
    public Restaurant getRestaurantById(@PathVariable("restaurantId") String restaurantId,
                                        @PathVariable("userId") String userId,
                                        @RequestHeader("X-Auth-Token") String token) throws Exception {

        System.out.println("TOKEN: " + token);
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);

        List<ServiceInstance> serviceList = client.getInstances(accountService);
        if (serviceList != null && serviceList.size() > 0) {
            URI uri = serviceList.get(0).getUri();
            if (uri != null) {
                // url for making request to Account service
                String baseUrl = uri.toString() + accountServicePath;
                System.out.println("BASE: " + baseUrl);
                String userRatingUrl = baseUrl + "/rating-restaurant/uid/" + userId + "/rid/" + restaurantId;
                System.out.println("RATING: " + userRatingUrl);
                String userBookmarkUrl = baseUrl + "/bookmark-restaurant/uid/" + userId +"/rid/" + restaurantId;
                System.out.println("BOOKMARK: " + userBookmarkUrl);
                String userCommentUrl = baseUrl + "/comment-restaurant/uid/" + userId + "/rid/" + restaurantId;
                System.out.println("COMMENT: " + userCommentUrl);

                HttpHeaders headers = new HttpHeaders();
                headers.set("X-Auth-Token", token);

                HttpEntity entity = new HttpEntity(headers);

                ResponseEntity<String> responseUserRating = new RestTemplate()
                        .exchange(userRatingUrl, HttpMethod.GET, entity, String.class);
                String userRatingResponse = responseUserRating.getBody();
                restaurant.setUserRating(userRatingResponse);
                System.out.println(userRatingResponse);

                ResponseEntity<String> responseUserBookmark = new RestTemplate()
                        .exchange(userBookmarkUrl, HttpMethod.GET, entity, String.class);
                String userBookmarkResponse = responseUserBookmark.getBody();
                if (userBookmarkResponse == null) {
                    restaurant.setUserBookmark("false");
                }
                else {
                    restaurant.setUserBookmark("true");
                }
                System.out.println(userBookmarkResponse);

                ResponseEntity<String> responseUserComment = new RestTemplate()
                        .exchange(userCommentUrl, HttpMethod.GET, entity, String.class);
                String userCommentResponse = responseUserComment.getBody();
                restaurant.setUserComment(userCommentResponse);
                System.out.println(userCommentResponse);

//                restaurant = restaurantService.updateRestaurantById(restaurantId, restaurant);
            }
        }

        return restaurant;
    }

    @GetMapping("/restaurant/city/{city}")
    public List<Restaurant> getRestaurantsByCity(@PathVariable("city") String city) throws Exception {
        return restaurantService.randomFiveRestaurants(city);
    }

    @GetMapping("/restaurant/city/{city}/label/{label}")
    public List<Restaurant> getRestaurantsByCityLabel(@PathVariable("city") String city, @PathVariable("label") String label)
        throws Exception {
        return restaurantService.randomFiveRestaurants(city, label);
    }

    @GetMapping("/yelp")
    public HttpStatus getAccessToken() throws IOException {
        return yelpService.generateAccessToken();
    }


}
