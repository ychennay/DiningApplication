package test.java.config;

import main.java.config.PropertyConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.java.AbstractTest;

/**
 * Created by ychen4 on 5/26/2017.
 * This Test class checks the configuration settings and makes sure they have been properly set
 */

@SpringBootTest(classes = PropertyConfiguration.class)
public class PropertyConfigurationTest extends AbstractTest {

    PropertyConfiguration propertyConfiguration;

    /**
     * This function sets up context by invoking before() implemented in AbstractTest
     */
    @Before
    public void before(){
        super.before();
        propertyConfiguration = super.propertyConfiguration;
    }

    /**
     * Check YelpGrantType configuration setting
     */
    @Test
    public void testYelpGrantType() {
        Assert.assertTrue(propertyConfiguration.getYelpGrantType().equals("client_credentials"));
    }

    /**
     * Check AccessTokenEndpoint configuration setting
     */
    @Test
    public void testAccessTokenEndpoint() {
        Assert.assertTrue(propertyConfiguration.getAccessTokenEndpoint().equals("https://api.yelp.com/oauth2/token"));
    }

    /**
     * Check YelpClientSecret configuration setting
     */
    @Test
    public void testYelpClientSecret() {
        Assert.assertTrue(propertyConfiguration.getYelpClientSecret().equals("bFlKK83z7W5Vcg9QqdQuheGNDTG68pQ9eYb9Ge0UFJ49euxeeFgIUkWKvHXdrAnP"));
    }

    /**
     * Check YelpClientID configuration setting
     */
    @Test
    public void testYelpClientID() {
        Assert.assertTrue(propertyConfiguration.getYelpClientId().equals("100V2Wp_cFWawQsAvtw8kQ"));
    }

    /**
     * Check YelpEndpoint configuration setting
     */
    @Test
    public void testYelpEndpoint() {
        Assert.assertTrue(propertyConfiguration.getYelpEndpoint().equals("https://api.yelp.com/v3/businesses/"));
    }

    /**
     * Check Endpoint configuration setting
     */
    @Test
    public void testEndpoint() {
        Assert.assertTrue(propertyConfiguration.getEndpoint().equals("http://localhost:8000/"));
    }

    /**
     * Check Region configuration setting
     */
    @Test
    public void testRegion() {
        Assert.assertTrue(propertyConfiguration.getRegion().equals("us-west-2"));
    }

    /**
     * Check YelpAcessToken configuration setting
     */
    @Test
    public void testYelpAccessToken(){
        Assert.assertTrue(propertyConfiguration.getYelpAccessToken().equals("OE5gGlZEQRDUl5Ctxh2gXyO59bJbkd0Y1dRs6OySV5qkdfJdh-59EVbsuQelWC4nvU_iN_sIEY5fU5OkeoC6VIdWMaoExSVFc99MNU_jrOVekgx1gVyamIl3rcsbWXYx"));
    }

}
