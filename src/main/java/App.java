package main.java;

import main.java.config.PropertyConfiguration;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Created by ychen4 on 5/4/2017.
 */

@SpringBootApplication
@EnableDiscoveryClient
public class App extends SpringBootServletInitializer{

 private static final Logger logger = Logger.getLogger(App.class.toString());

    public static void main(String[] args) throws Exception {

        String configFile = "configuration.xml";
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext(configFile);
        PropertyConfiguration configuration = (PropertyConfiguration) context.getBean("propertyConfiguration");

        SpringApplication.run(App.class, args);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(appClass);
    }
    private static Class<App> appClass = App.class;

}


