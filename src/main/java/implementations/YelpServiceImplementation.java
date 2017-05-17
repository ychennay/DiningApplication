package main.java.implementations;

import main.java.config.Constants;
import main.java.config.PropertyConfiguration;
import main.java.service.YelpService;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by ychen4 on 5/16/2017.
 */
@Component
public class YelpServiceImplementation implements YelpService {

    private ConfigurableApplicationContext context =
            new ClassPathXmlApplicationContext("configuration.xml");

    @Override
    public String retrieveAllRestaurants() {
        return null;
    }

    @Override
    public String retrieveRestaurant(String restaurantName) {
        return null;
    }

    @Override
    public HttpStatus generateAccessToken() throws IOException {
        PropertyConfiguration properties = (PropertyConfiguration)
                context.getBean("propertyConfiguration");

        URL url = new URL(properties.getAccessTokenEndpoint());

        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(properties.getAccessTokenEndpoint());

        List<NameValuePair> parameters = new ArrayList<NameValuePair>(2);
        parameters.add(new BasicNameValuePair( "client_id", properties.getYelpClientId()));
        parameters.add(new BasicNameValuePair("client_secret", properties.getYelpClientSecret()));
        parameters.add(new BasicNameValuePair("grant_type", properties.getYelpGrantType()));
        httpPost.setEntity(new UrlEncodedFormEntity(parameters));

        HttpResponse response = httpClient.execute(httpPost);
        String responseString = new BasicResponseHandler().handleResponse(response);
        try {
            JSONObject jsonObject = new JSONObject(responseString);
            String accessToken = (String) jsonObject.get("access_token");

            FileInputStream input = new FileInputStream(Constants.PROPERTIES_FILEPATH);
            Properties props = new Properties();
            props.load(input);
            input.close();

            FileOutputStream out = new FileOutputStream(Constants.PROPERTIES_FILEPATH);
            props.setProperty("yelp.fusion.accessToken", accessToken);
            props.store(out, null);
            out.close();

            return HttpStatus.CREATED;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return HttpStatus.BAD_REQUEST;
    }
}
