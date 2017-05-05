package main.java.service;

import main.java.model.Review;

import java.util.List;

/**
 * Created by ychen4 on 5/4/2017.
 */
public interface ReviewService {

    List<Review> listAllReviews();

    Review getReviewById(int id);

    Review saveReview(Review review);

    Review updateReview(int id);

    Review deleteReview(int id);

}
