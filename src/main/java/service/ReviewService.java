package main.java.service;

import main.java.model.Review;

/**
 * Created by ychen4 on 5/4/2017.
 */
public interface ReviewService {

    Iterable<Review> listAllReviews();

    Review getReviewById(int id);

    Review saveReview(Review review);

    Review updateReview(int id);

    Review deleteReview(int id);

}
