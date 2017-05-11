package main.java;

import main.java.dao.DynamoClientMapper;
import main.java.model.Restaurant;
import main.java.service.RestaurantService;
import main.java.service.RestaurantServiceImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by ychen4 on 5/4/2017.
 */
//@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class App extends SpringBootServletInitializer{

//    private static final Logger logger = Logger.getLogger(App.class.toString());

    public static void main(String[] args) throws Exception {
        DynamoClientMapper dynamoClientMapper = new DynamoClientMapper();

        dynamoClientMapper.initAWSCreds();
        dynamoClientMapper.readRestaurantItem("fil-am-bbq-grill-orange");

        List<Restaurant> restaurantList = dynamoClientMapper.scanTable("restaurant");

        String firstRestaurantName = restaurantList.get(0).getName();
        System.out.println("Restaurant: " + firstRestaurantName);

        SpringApplication.run(App.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(appClass);
    }

    private static Class<App> appClass = App.class;

}


