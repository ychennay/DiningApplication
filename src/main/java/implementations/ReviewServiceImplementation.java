package main.java.implementations;


import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import main.java.dao.DynamoClientMapper;
import main.java.model.Review;
import main.java.service.ReviewService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ychen4 on 4/30/2017.
 */

@Component
public class ReviewServiceImplementation implements ReviewService {

    private static Logger logger = Logger.getLogger(ReviewServiceImplementation.class.getName());
    private static List<Review> reviews;
    public ReviewServiceImplementation(){
        logger.info("ReviewServiceImplementation initialized");
        DynamoClientMapper dynamoClientMapper = new DynamoClientMapper();


        reviews = new ArrayList();
        reviews.add(new Review(1, "ychennay", "This restaurant was terrific!", "04-30-2001"));
        reviews.add(new Review(2, "david", "This restaurant was okay!", "09-11-2000"));
        reviews.add(new Review(3, "ben", "This restaurant was mediocre!", "08-31-1923"));
        reviews.add(new Review(4, "leon", "This restaurant was awful!", "03-01-2001"));
        reviews.add(new Review(5, "lawrence", "This restaurant was confusing!", "03-01-2001"));
    }


    public Review createReview(Review review){
        DynamoClientMapper clientMapper = new DynamoClientMapper();
        DynamoDB dynamoDB = clientMapper.getDynamoDB();
        Table reviewTable = dynamoDB.getTable("restaurant-review");

        UpdateItemSpec updateItemSpec = new UpdateItemSpec()
                .withPrimaryKey("id", review.getId())
                .withUpdateExpression("set ReviewDate = :r," +
                        "ReviewText =:t," +
                        "UserName =:u")
                .withValueMap(new ValueMap()
                        .withString(":r", review.getReviewDate())
                        .withString(":t", review.getReviewText())
                        .withString("u", review.getUserName()))
                .withReturnValues(ReturnValue.UPDATED_NEW);
        try{
            logger.info("Updating item " + review.toString());
            UpdateItemOutcome outcome = reviewTable.updateItem(updateItemSpec);
            logger.info("Update succeeded:\n" + outcome.getItem().toJSONPretty());
            return review;
        } catch (Exception e){
            logger.error("Unable to update the item: " + review);
            logger.error(e.getMessage());
            return null;
        }
    }



    @Override
    public List<Review> listAllReviews() {
            return reviews;
    }


    public Review getReviewById(int id) {
            for (Review r: reviews){
                if (r.getId() == id){
                    return r;
                }
            }
            return null;
    }


    public Review saveReview(Review review) {
            review.setId((int)Math.random());
            reviews.add(review);
            return review;
    }

    @Override
    public Review updateReview(Review review) {
        return null;
    }

    @Override
    public Review deleteReview(int id) {
        return null;
    }
}
