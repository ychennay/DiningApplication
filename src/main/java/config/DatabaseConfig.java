package main.java.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.util.StringUtils;
import org.slf4j.LoggerFactory;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import java.util.logging.Logger;

/**
 * Created by ychen4 on 5/4/2017.
 */

@EnableAutoConfiguration
@EnableDynamoDBRepositories(basePackages = "main.dao")
public class DatabaseConfig {

    private final Logger logger = (Logger) LoggerFactory.getLogger("Logger");

    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB(AWSCredentials awsCredentials) {
        logger.info("Entering AmazonDynamoDB");
        AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(awsCredentials);
        if (StringUtils.isNullOrEmpty(amazonDynamoDBEndpoint)) {

        } else {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
        }
        return amazonDynamoDB;
    }
    @Bean
    public AWSCredentials awsCredentials(){
        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }
}
