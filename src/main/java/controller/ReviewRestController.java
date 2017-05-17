package main.java.controller;


import main.java.model.Review;
import main.java.implementations.ReviewServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewRestController extends GenericRestController{

    private ReviewServiceImplementation reviewServiceImplementation;

    @Autowired
    public ReviewRestController(ReviewServiceImplementation reviewServiceImplementation) {
        this.reviewServiceImplementation = reviewServiceImplementation;
    }

    @GetMapping("/api/reviews")
    public List getReviews() {
        return reviewServiceImplementation.listAllReviews();
    }

    @GetMapping("/api/reviews/{id}")
    public ResponseEntity getReview(@PathVariable("id") int id) {
        System.out.println("Getting ID number " + id);
        Review review = reviewServiceImplementation.getReviewById(id);
        if(review == null){
            return new ResponseEntity("This review does not exist", HttpStatus.NOT_FOUND);}
        return new ResponseEntity(review, HttpStatus.OK);
    }

    @PostMapping("/api/reviews/create")
    public ResponseEntity createReview(@RequestBody Review review){
        reviewServiceImplementation.createReview(review);
        return new ResponseEntity(review, HttpStatus.OK);
    }

}
