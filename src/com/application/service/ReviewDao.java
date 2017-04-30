package com.application.service;

import com.application.model.Review;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ychen4 on 4/30/2017.
 */

@Component
public class ReviewDao {

    private static List<Review> reviews;
    {
        reviews = new ArrayList();
        reviews.add(new Review(1, "ychennay", "This restaurant was terrific!"));
        reviews.add(new Review(2, "david", "This restaurant was okay!"));
        reviews.add(new Review(3, "ben", "This restaurant was mediocre!"));
        reviews.add(new Review(4, "leon", "This restaurant was awful!"));
        reviews.add(new Review(5, "lawrence", "This restaurant was confusing!"));
    }

    public List list(){
        return reviews;
    }

    public Review get(int id){
        for (Review r: reviews){
            if (r.getId() == id){
                return r;
            }
        }
    return null;
    }

    public Review create(Review review){
        review.setId((int)Math.random());
        reviews.add(review);
        return review;
    }


}
