package test.java;

import ch.qos.logback.classic.selector.servlet.LoggerContextFilter;
import main.java.App;
import main.java.config.PropertyConfiguration;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by ychen4 on 5/26/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public abstract class AbstractTest {

    protected Logger logger = Logger.getLogger(this.getClass().toString());
    public PropertyConfiguration propertyConfiguration;

    @Before
    public void before(){
        String configFile = "configuration.xml";
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext(configFile);
        propertyConfiguration = (PropertyConfiguration) context.getBean("propertyConfiguration");
    }


}
