package main.java.controller;

import main.java.implementations.RestaurantServiceImplementation;
import main.java.implementations.YelpServiceImplementation;
import main.java.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.joox.JOOX.$;

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

    /**
     * method returns a restaurant object using path variables
     * @param restaurantId the ID of the restaurant to query
     * @param userId the ID of the user
     * @param token the string authentication access token used for security/validation
     * @return Restaurant info that contains user info as well
     */
    @RequestMapping("/restaurant/{restaurantId}/user/{userId}")
    public Restaurant getRestaurantById(@PathVariable("restaurantId") String restaurantId,
                                        @PathVariable("userId") String userId,
                                        @RequestHeader("X-Auth-Token") String token)
            throws ParserConfigurationException, IOException, SAXException {

        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);

        List<ServiceInstance> serviceList = client.getInstances(accountService);
        if (serviceList != null && serviceList.size() > 0) {
            URI uri = serviceList.get(0).getUri();
            if (uri != null) {
                // url for making request to Account service
                String baseUrl = uri.toString() + accountServicePath;
                String userRatingUrl = baseUrl + "/rating-restaurant/uid/" + userId + "/rid/" + restaurantId;
                String userBookmarkUrl = baseUrl + "/bookmark-restaurant/uid/" + userId +"/rid/" + restaurantId;
                String userCommentUrl = baseUrl + "/comment-restaurant/uid/" + userId + "/rid/" + restaurantId;
                String averageRatingUrl = baseUrl + "/rating-restaurant/rid/" + restaurantId;
                String allCommentsUrl = baseUrl + "/comment-restaurant/rid/" + restaurantId;

                HttpHeaders headers = new HttpHeaders();
                headers.set("X-Auth-Token", token);

                HttpEntity entity = new HttpEntity(headers);

                ResponseEntity<String> responseUserRating = new RestTemplate()
                        .exchange(userRatingUrl, HttpMethod.GET, entity, String.class);
                String userRatingResponse = responseUserRating.getBody();
                if (userRatingResponse == null) {
                    restaurant.setUserRating("");
                }
                else {
                    String rating = $(userRatingResponse).find("rating").text();
                    restaurant.setUserRating(rating);
                }

                ResponseEntity<String> responseUserBookmark = new RestTemplate()
                        .exchange(userBookmarkUrl, HttpMethod.GET, entity, String.class);
                String userBookmarkResponse = responseUserBookmark.getBody();
                if (userBookmarkResponse == null) {
                    restaurant.setUserBookmark("false");
                }
                else {
                    restaurant.setUserBookmark("true");
                }

                ResponseEntity<String> responseUserComment = new RestTemplate()
                        .exchange(userCommentUrl, HttpMethod.GET, entity, String.class);
                String userCommentResponse = responseUserComment.getBody();
                if (userCommentResponse == null) {
                    restaurant.setUserComment("");
                }
                else {
                    String comment = $(userCommentResponse).find("comment").text();
                    restaurant.setUserComment(comment);
                }

                ResponseEntity<String> responseAverageRating = new RestTemplate()
                        .exchange(averageRatingUrl, HttpMethod.GET, entity, String.class);
                String averageRatingResponse = responseAverageRating.getBody();
                if (averageRatingResponse == null) {
                    restaurant.setAverageRating("");
                }
                else {
                    String averageRating = $(averageRatingResponse).find("rating").text();
                    restaurant.setAverageRating(averageRating);
                }

                ResponseEntity<String> responseAllComments = new RestTemplate()
                        .exchange(allCommentsUrl, HttpMethod.GET, entity, String.class);
                String allCommentsResponse = responseAllComments.getBody();
                if (allCommentsResponse == null) {
                    restaurant.setAllComments(null);
                }
                else {
                    List<Map<String, String>> listMapAllComments = new LinkedList<>();

                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    InputSource is = new InputSource(new StringReader(allCommentsResponse));
                    Document doc = builder.parse(is);

                    NodeList commentList = doc.getElementsByTagName("item");
                    for (int i = 0; i < commentList.getLength(); ++i)
                    {
                        Map<String, String> mapComment = new HashMap<>();

                        Element element = (Element) commentList.item(i);

                        // Do not return user's comment in the list of comments since already in Restaurant object
                        NodeList userIdList = element.getElementsByTagName("userId");
                        Element userIdElement = (Element) userIdList.item(0);
                        String userIdFromList = userIdElement.getFirstChild().getNodeValue();

                        if (!userIdFromList.equals(userId)) {
                            NodeList userNameList = element.getElementsByTagName("userName");
                            Element userNameElement = (Element) userNameList.item(0);
                            String userName = userNameElement.getFirstChild().getNodeValue();
                            mapComment.put("userName", userName);

                            NodeList userCommentList = element.getElementsByTagName("comment");
                            Element userCommentElement = (Element) userCommentList.item(0);
                            String comment = userCommentElement.getFirstChild().getNodeValue();
                            mapComment.put("comment", comment);

                            listMapAllComments.add(mapComment);
                        }
                    }
                    restaurant.setAllComments(listMapAllComments);
                }
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
