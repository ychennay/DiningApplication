package main.java.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by ychen4 on 5/4/2017.
 */

public class PropertyConfiguration {


    private String endpoint;
    private String region;
    private String accessKey;
    private String secretKey;
    private String yelpEndpoint;

    public String getYelpEndpoint() {
        return yelpEndpoint;
    }

    public void setYelpEndpoint(String yelpEndpoint) {
        this.yelpEndpoint = yelpEndpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public String toString() {
        return "PropertyConfiguration{" +
                "endpoint='" + endpoint + '\'' +
                ", region='" + region + '\'' +
                ", accessKey='" + accessKey + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", yelpEndpoint='" + yelpEndpoint + '\'' +
                '}';
    }

    public PropertyConfiguration() {
    this.endpoint = endpoint;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
