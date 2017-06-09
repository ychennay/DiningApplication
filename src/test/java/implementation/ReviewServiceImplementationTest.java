package test.java.implementation;

import main.java.config.PropertyConfiguration;
import main.java.implementations.ReviewServiceImplementation;
import main.java.implementations.YelpServiceImplementation;
import main.java.model.Review;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import test.java.AbstractTest;

import java.util.List;

/**
 * Created by Leon on 6/8/2017.
 */
@SpringBootTest(classes = ReviewServiceImplementation.class)
public class ReviewServiceImplementationTest extends AbstractTest {

    @Autowired
    private ReviewServiceImplementation reviewServiceImplementation;

    public PropertyConfiguration propertyConfiguration;

    @Before
    public void before(){
        super.before();
        propertyConfiguration = super.propertyConfiguration;
    }

    @Test
    public void getReviewByIDTest() {
        Review result = reviewServiceImplementation.getReviewById(1);
        Assert.assertTrue(result.getReviewText() == "This restaurant was terrific!");
    }

    @Test
    public void listAllReviewsTest(){
        List<Review> result = reviewServiceImplementation.listAllReviews();
        Assert.assertFalse(result.isEmpty());
    }
}
