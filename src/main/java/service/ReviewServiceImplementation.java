package main.java.service;


import main.java.model.Review;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ychen4 on 4/30/2017.
 */

@Component
public class ReviewServiceImplementation implements ReviewService{

    private static List<Review> reviews;
    {
        reviews = new ArrayList();
        reviews.add(new Review(1, "ychennay", "This restaurant was terrific!"));
        reviews.add(new Review(2, "david", "This restaurant was okay!"));
        reviews.add(new Review(3, "ben", "This restaurant was mediocre!"));
        reviews.add(new Review(4, "leon", "This restaurant was awful!"));
        reviews.add(new Review(5, "lawrence", "This restaurant was confusing!"));
    }


    public Review create(Review review){
        return null;
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
    public Review updateReview(int id) {
        return null;
    }

    @Override
    public Review deleteReview(int id) {
        return null;
    }
}
