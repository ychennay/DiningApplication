package com.application.controller;

import com.application.model.Review;
import com.application.service.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewRestController {

    @Autowired
    private ReviewDao reviewDao;

    @GetMapping("/reviews")
        public List getReviews() {
        return reviewDao.list();}

    @GetMapping("/reviews/{id}")
    public ResponseEntity getReview(@PathVariable("id") int id) {
        System.out.println("Getting ID number " + id);
        Review review = reviewDao.get(id);
        if(review == null){
            return new ResponseEntity("This review does not exist", HttpStatus.NOT_FOUND);}
        return new ResponseEntity(review, HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity createReview(@RequestBody Review review){
        reviewDao.create(review);
        return new ResponseEntity(review, HttpStatus.OK);
    }

}
