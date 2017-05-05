package main.java.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ychen4 on 5/4/2017.
 */

@Configuration
@EnableDynamoDBRepositories
public class DatabaseConfig {

    @Value("${dynamodb.endpoint}")
    private String endpoint;

    @Value("${aws.accesskey}")
    private String accessKey;

    @Value("${aws.secretkey}")
    private String secretKey;



}
