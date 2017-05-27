package main.java.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

/**
 * Created by ychen4 on 5/4/2017.
 */

public class PropertyConfiguration {

    private String endpoint;
    private String region;
    private String accessKey;
    private String secretKey;
    private String yelpEndpoint;
    private String yelpClientSecret;
    private String yelpClientId;
    private String accessTokenEndpoint;
    private String yelpAccessToken;
    private String yelpGrantType;
    private String restaurantSearchEndpoint;


    public String getYelpGrantType() {
        return yelpGrantType;
    }

    public void setYelpGrantType(String yelpGrantType) {
        this.yelpGrantType = yelpGrantType;
    }

    @Override
    public String toString() {
        return "PropertyConfiguration{" +
                "endpoint='" + endpoint + '\'' +
                ", region='" + region + '\'' +
                ", accessKey='" + accessKey + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", yelpEndpoint='" + yelpEndpoint + '\'' +
                ", yelpClientSecret='" + yelpClientSecret + '\'' +
                ", yelpClientId='" + yelpClientId + '\'' +
                ", accessTokenEndpoint='" + accessTokenEndpoint + '\'' +
                ", yelpGrantType='" + yelpGrantType + '\'' +
                '}';
    }

    public String getAccessTokenEndpoint() {
        return accessTokenEndpoint;
    }

    public void setAccessTokenEndpoint(String accessTokenEndpoint) {
        this.accessTokenEndpoint = accessTokenEndpoint;
    }

    public String getYelpClientSecret() {
        return yelpClientSecret;
    }

    public void setYelpClientSecret(String yelpClientSecret) {
        this.yelpClientSecret = yelpClientSecret;
    }

    public String getYelpClientId() {
        return yelpClientId;
    }

    public void setYelpClientId(String yelpClientId) {
        this.yelpClientId = yelpClientId;
    }

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

    public String getYelpAccessToken() {
        return yelpAccessToken;
    }

    public void setYelpAccessToken(String yelpAccessToken) {
        this.yelpAccessToken = yelpAccessToken;
    }

    public String getRestaurantSearchEndpoint() {
        return restaurantSearchEndpoint;
    }

    public void setRestaurantSearchEndpoint(String restaurantSearchEndpoint) {
        this.restaurantSearchEndpoint = restaurantSearchEndpoint;
    }
}
