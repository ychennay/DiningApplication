package main.java.dao;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import main.java.model.Restaurant;
import org.springframework.context.annotation.PropertySource;

import java.util.*;

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

    public void initAWSCreds() {
        /* Hard coding AWS credentials until we figure out how to get values from properties */
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKeyId, secretKeyId);

        client = AmazonDynamoDBClientBuilder.standard()
//                .withEndpointConfiguration(new EndpointConfiguration(endpoint, region)) // For now EndpointConfiguration does not work
                .withRegion(Regions.US_WEST_2)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();

        dynamoDB = new DynamoDB(client);
    }

    public void readRestaurantItem(String id) throws Exception {

        Table table = dynamoDB.getTable("restaurant");

        GetItemSpec spec = new GetItemSpec().withPrimaryKey("restaurant-id", id);

        try {
            System.out.println("Attempting to read the item...");
            Item outcome = table.getItem(spec);
            System.out.println("GetItem succeeded: " + outcome.toJSONPretty());
        } catch (Exception e) {
            System.err.println("Unable to read item: " + id);
            System.err.println(e.getMessage());
        }
    }

    public List<Restaurant> scanTable(String tableName) {

        Table table = dynamoDB.getTable(tableName);

//         Arbitrarily chose LinkedList as List implementation
        List<Restaurant> restaurantList = new LinkedList<Restaurant>();

        try {
            ItemCollection<ScanOutcome> items = table.scan();

            Iterator<Item> iter = items.iterator();
            while (iter.hasNext()) {
                Item item = iter.next();

                Restaurant restaurant = new Restaurant(item.getString("restaurant-id"));

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

                restaurantList.add(restaurant);
//                Print out all restaurants in JSON format
//                System.out.println(item.toJSONPretty());
            }

        } catch (Exception e) {
            System.err.println("Unable to scan the table:");
            System.err.println(e.getMessage());
        }

        return restaurantList;
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
