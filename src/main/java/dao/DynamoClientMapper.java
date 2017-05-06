package main.java.dao;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@PropertySource(value = "database.properties", ignoreResourceNotFound = true)
public class DynamoClientMapper {

    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey:'key1'}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey:'key2'}")
    private String amazonAWSSecretKey;

    @Value("${amazon.aws.region:'us-west-1'}")
    private String amazonAWSRegion;

    private AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
            new EndpointConfiguration(amazonDynamoDBEndpoint, "us-west-1")).build();

    private AWSCredentials awsCredentials = new AWSCredentials() {
        @Override
        public String getAWSAccessKeyId() {
            return null;
        }

        @Override
        public String getAWSSecretKey() {
            return null;
        }
    };
    private DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDB);

    public DynamoDBMapper getMapper() {
        return mapper;
    }

}
