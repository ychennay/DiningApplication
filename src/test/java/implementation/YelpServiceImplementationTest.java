package test.java.implementation;

import main.java.config.PropertyConfiguration;
import main.java.implementations.YelpServiceImplementation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import test.java.AbstractTest;

import java.net.MalformedURLException;

/**
 * Created by ychen4 on 5/26/2017.
 * This test class checks the implementation functions of Yelp Service
 */
@SpringBootTest(classes = YelpServiceImplementation.class)
public class YelpServiceImplementationTest extends AbstractTest {

    @Autowired
    private YelpServiceImplementation yelpServiceImplementation;

    public PropertyConfiguration propertyConfiguration;

    /**
     * This function sets up context by invoking before() implemented in AbstractTest
     */
    @Before
    public void before(){
        super.before();
        propertyConfiguration = super.propertyConfiguration;
    }

    /**
     * This test function will test the retrieval of Yelp Fusion Access token and makes sure it is 128 chars
     */
    @Test
    public void retrieveAccessTokenTest(){
        String yelpAccessToken = propertyConfiguration.getYelpAccessToken();
        /*** all Yelp Fusion access tokens should be 128 chars **/
        logger.info("Yelp Access Token length: " + yelpAccessToken.length());
        Assert.assertTrue(yelpAccessToken.length() == 128);
    }

    /**
     * This test function will test to make sure a call to retrieve a specific restaurant is successful and does not throw exceptions
     * @throws MalformedURLException
     */
    @Test
    public void retrieveRestaurantsTest() throws MalformedURLException {
        String result = yelpServiceImplementation.retrieveRestaurants("Tsujita");
        Assert.assertFalse(result.isEmpty());
    }

    /**
     * This test function will test to make sure a call to retrieve all restaurants is successful and does not throw exceptions
     * @throws MalformedURLException
     */
    @Test
    public void retrieveAllRestaurantsTest() throws MalformedURLException {
        String result = yelpServiceImplementation.retrieveAllRestaurants();
        Assert.assertFalse(result.isEmpty());
    }


    @After
    public void tearDown(){

    }



}
