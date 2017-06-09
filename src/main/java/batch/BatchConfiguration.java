package main.java.batch;

import main.java.App;
import main.java.batch.processors.RestaurantItemProcessor;
import org.apache.log4j.Logger;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by ychen4 on 5/26/2017.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    private static final Logger logger = Logger.getLogger(App.class.toString());

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public RestaurantItemProcessor restaurantItemProcessor(){
        return new RestaurantItemProcessor();
    }

}
