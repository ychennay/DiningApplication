package main.java.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * Created by ychen4 on 4/30/2017.
 */

@DynamoDBTable(tableName = "Review")
public class Review {

    public int id;
    public String userName;
    public String reviewText;

    public Review(int id, String userName, String reviewText) {
        this.id = id;
        this.userName = userName;
        this.reviewText = reviewText;
    }

    public Review(){}

    @DynamoDBHashKey(attributeName = "Id")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "UserName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @DynamoDBAttribute(attributeName = "ReviewText")
    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", reviewText='" + reviewText + '\'' +
                '}';
    }
}
