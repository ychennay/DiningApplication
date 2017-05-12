package main.java.dao;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import main.java.model.Restaurant;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@PropertySource(value = "database.properties", ignoreResourceNotFound = true)
public class DynamoClientMapper {

/* For now, hard coding aws credentials
    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey:'key1'}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey:'key2'}")
    private String amazonAWSSecretKey;

    @Value("${amazon.aws.region:'us-west-1'}")
    private String amazonAWSRegion;
*/

    private DynamoDB dynamoDB;
    private AmazonDynamoDB client;

    // Endpoint will later change to actual url accessible via internet
    private String endpoint = "http://localhost:8000/";
    // Data are stored in AWS DynamoDB Oregon
    private String region = "us-west-2";
    private String accessKeyId = "AKIAJSGO3QGNX66I5WQA";
    private String secretKeyId = "esz7ufxQ8JrFevYPUhfrs5TCQEbK+YE3Mq5nFIoq";

    private Map<String, Restaurant> restaurantMap;
    private Map<String, List<String>> cityMap;
    private Map<String, Map<String, List<String>>> cityLabelMap;
    private List<String> labelList;
    private List<String> cityList;

    public DynamoClientMapper() {
        initAWSCreds();
        createRestaurantMap();
        createLabelList();
        createCityList();
        createCityMap();
        createCityLabelMap();
    }

    public Map<String, Restaurant> getRestaurantMap() {
        return this.restaurantMap;
    }

    public Map<String, List<String>> getCityMap() {
        return this.cityMap;
    }

    public Map<String, Map<String, List<String>>> getCityLabelMap() {
        return this.cityLabelMap;
    }

    private void initAWSCreds() {
        /* Hard coding AWS credentials until we figure out how to get values from properties */
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKeyId, secretKeyId);

        client = AmazonDynamoDBClientBuilder.standard()
//                .withEndpointConfiguration(new EndpointConfiguration(endpoint, region)) // For now EndpointConfiguration does not work
                .withRegion(Regions.US_WEST_2)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();

        this.dynamoDB = new DynamoDB(client);
    }

    private void createRestaurantMap() {

        String tableName = "restaurant";
        Table table = dynamoDB.getTable(tableName);

//         Arbitrarily chose LinkedList as List implementation
        Map<String, Restaurant> restaurantMap = new HashMap<>();

        try {
            ItemCollection<ScanOutcome> items = table.scan();

            Iterator<Item> iter = items.iterator();
            while (iter.hasNext()) {
                Item item = iter.next();

                String restaurantId = item.getString("restaurant-id");
                Restaurant restaurant = new Restaurant(restaurantId);

                restaurant.setAddress(item.getStringSet("address"));
                restaurant.setCity(item.getString("city"));
                restaurant.setCountryCode(item.getString("country_code"));
                restaurant.setDisplayAddress(item.getStringSet("display_address"));
                restaurant.setDisplayPhone(item.getString("display_phone"));
                restaurant.setGeoAccuracy(item.getInt("geo_accuracy"));
                restaurant.setId(item.getString("id"));
                restaurant.setImageUrl(item.getString("image_url"));
                restaurant.setIsClaimed(item.getString("is_claimed"));
                restaurant.setIsClosed(item.getString("is_closed"));
                restaurant.setLatitude(item.getFloat("latitude"));
                restaurant.setLongitude(item.getFloat("longitude"));
                restaurant.setMobileUrl(item.getString("mobile_url"));
                restaurant.setName(item.getString("name"));
                restaurant.setPhone(item.getString("phone"));
                restaurant.setPostalCode(item.getString("postal_code"));
                restaurant.setRating(item.getFloat("rating"));
                restaurant.setRatingImgUrl(item.getString("rating_img_url"));
                restaurant.setRatingImgUrlLarge(item.getString("rating_img_url_large"));
                restaurant.setRatingImgUrlSmall(item.getString("rating_img_url_small"));
                restaurant.setReviewCount(item.getInt("review_count"));
                restaurant.setSnippetImgUrl(item.getString("snippet_image_url"));
                restaurant.setSnippetText(item.getString("snippet_text"));
                restaurant.setStateCode(item.getString("state_code"));
                restaurant.setUrl(item.getString("url"));

                restaurantMap.put(restaurantId, restaurant);
//                Print out all restaurants in JSON format
//                System.out.println(item.toJSONPretty());
            }

        } catch (Exception e) {
            System.err.println("Unable to scan the table:");
            System.err.println(e.getMessage());
        }

        this.restaurantMap = restaurantMap;
    }

    private void createLabelList() {

        String tableName = "label";
        Table table = dynamoDB.getTable(tableName);

//         Arbitrarily chose LinkedList as List implementation
        List<String> labelList = new LinkedList<>();

        try {
            ItemCollection<ScanOutcome> items = table.scan();

            Iterator<Item> iter = items.iterator();
            while (iter.hasNext()) {
                Item item = iter.next();
                labelList.add(item.getString("label-id"));
            }

        } catch (Exception e) {
            System.err.println("Unable to scan the table:");
            System.err.println(e.getMessage());
        }

        this.labelList = labelList;
    }

    public void createCityList() {

        String tableName = "restaurant";
        Table table = dynamoDB.getTable(tableName);

        List<String> cityList = new LinkedList<>();

        try {
            ItemCollection<ScanOutcome> items = table.scan();

            Iterator<Item> iter = items.iterator();
            while (iter.hasNext()) {
                Item item = iter.next();
                String city = item.getString("city");
                if (!cityList.contains(city)) {
                    cityList.add(city);
                }
            }
        } catch (Exception e) {
            System.err.println("Unable to scan the table:");
            System.err.println(e.getMessage());
        }

        this.cityList = cityList;
    }

    private void createCityMap() {

        Map<String, List<String>> cityMap = new HashMap<>();

        try {
            /* initializing filterMap */
            for (String city: cityList) {
                List<String> restaurantIdList = new LinkedList<>();
                cityMap.put(city, restaurantIdList);
            }

            Collection<Restaurant> restaurantCollection = restaurantMap.values();
            Iterator<Restaurant> iter = restaurantCollection.iterator();
            while (iter.hasNext()){
                Restaurant restaurant = iter.next();
                String city = restaurant.getCity();
                String restaurantId = restaurant.getRestaurantId();
                cityMap.get(city).add(restaurantId);
            }
        } catch (Exception e) {
            System.err.println("Unable to create filter table:");
            System.err.println(e.getMessage());
        }

        this.cityMap = cityMap;
    }

    private void createCityLabelMap() {

        String tableName = "restaurant-label";
        Table table = dynamoDB.getTable(tableName);

        Map<String, Map<String, List<String>>> cityLabelMap = new HashMap<>();

        try {
            /* initializing filterMap */
            for (String city: cityList) {
                Map<String, List<String>> labelMap = new HashMap<>();
                for (String label: labelList) {
                    List<String> restaurantIdList = new LinkedList<>();
                    labelMap.put(label, restaurantIdList);
                }
                cityLabelMap.put(city, labelMap);
            }

            ItemCollection<ScanOutcome> items = table.scan();

            Iterator<Item> iter = items.iterator();
            while (iter.hasNext()) {
                Item item = iter.next();
                String labelId = item.getString("label-id");
                String restaurantId = item.getString("restaurant-id");
                if (restaurantMap.containsKey(restaurantId)) {
                    Restaurant restaurant = restaurantMap.get(restaurantId);
                    String city = restaurant.getCity();
                    cityLabelMap.get(city).get(labelId).add(restaurantId);
                }
            }
        } catch (Exception e) {
            System.err.println("Unable to create filter table:");
            System.err.println(e.getMessage());
        }

        this.cityLabelMap = cityLabelMap;
    }

//    private AWSCredentials awsCredentials = new AWSCredentials() {
//        @Override
//        public String getAWSAccessKeyId() {
//            return null;
//        }
//
//        @Override
//        public String getAWSSecretKey() {
//            return null;
//        }
//    };
//    private DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDB);
//
//    public DynamoDBMapper getMapper() {
//        return mapper;
//    }

}
