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
 */
@SpringBootTest(classes = YelpServiceImplementation.class)
public class YelpServiceImplementationTest extends AbstractTest {

    @Autowired
    private YelpServiceImplementation yelpServiceImplementation;

    public PropertyConfiguration propertyConfiguration;

    @Before
    public void before(){
        super.before();
        propertyConfiguration = super.propertyConfiguration;
    }


    @Test
    public void retrieveAccessTokenTest(){
        String yelpAccessToken = propertyConfiguration.getYelpAccessToken();
        /*** all Yelp Fusion access tokens should be 128 chars **/
        logger.info("Yelp Access Token length: " + yelpAccessToken.length());
        Assert.assertTrue(yelpAccessToken.length() == 128);
    }


    @Test
    public void retrieveRestaurantsTest() throws MalformedURLException {
        String result = yelpServiceImplementation.retrieveRestaurants("Tsujita");
        Assert.assertFalse(result.isEmpty());
    }



    @After
    public void tearDown(){

    }



}
