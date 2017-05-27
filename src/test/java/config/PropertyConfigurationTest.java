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
 */
@SpringBootTest(classes = PropertyConfiguration.class)
public class PropertyConfigurationTest extends AbstractTest {

    PropertyConfiguration propertyConfiguration;

    @Before
    public void before(){
        super.before();
        propertyConfiguration = super.propertyConfiguration;
    }

    @Test
    public void testProperty(){
        Assert.assertTrue(propertyConfiguration.getYelpGrantType().equals("client_credentials"));
        Assert.assertTrue(propertyConfiguration.getRegion().equals("us-west-2"));
        Assert.assertTrue(propertyConfiguration.getEndpoint().equals("http://localhost:8000/"));
        Assert.assertTrue(propertyConfiguration.getYelpClientId().equals("100V2Wp_cFWawQsAvtw8kQ"));
    }
}
