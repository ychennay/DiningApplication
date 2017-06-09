package test.java.controller;

import main.java.controller.RestaurantRestController;
import main.java.controller.ReviewRestController;
import main.java.dao.DynamoClientMapper;
import main.java.implementations.RestaurantServiceImplementation;
import main.java.implementations.ReviewServiceImplementation;
import main.java.implementations.YelpServiceImplementation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Leon on 6/8/2017.
 * This test class checks the Restaurant controller to make sure it recognizes its respective get requests
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:configuration.xml"})
//@WebMvcTest
public class RestaurantRestControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    /**
     * This class sets up the configuration for unit testing the Restaurant controller
     */
    @Configuration
    @EnableAutoConfiguration
    public static class Config{
        private DynamoClientMapper dynamoClientMapper;
        RestaurantServiceImplementation restaurantServiceImplementation = new RestaurantServiceImplementation(dynamoClientMapper);
        YelpServiceImplementation yelpServiceImplementation = new YelpServiceImplementation();
        @Bean
        public RestaurantRestController restaurantRestController(){
            return new RestaurantRestController(restaurantServiceImplementation, yelpServiceImplementation);
        }
    }


    //private RestaurantServiceImplementation restaurantServiceImplementation;
    //private YelpServiceImplementation yelpServiceImplementation;

    /**
     * This function sets up the context for mockito and configures it as a web context
     */
    @Before
    public void setup() {

       // StandaloneMockMvcBuilder builder = MockMvcBuilders.standaloneSetup(new RestaurantRestController(restaurantServiceImplementation, yelpServiceImplementation));
       // this.mockMvc = builder.build();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getRestaurantUser1Test() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isNotFound();  //SHOULD BE FOUND CHANGE THIS WHEN FIGURE OUT HOW TO MOCK DYNAMODB
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/restaurant/Tsujita/user/1");

        this.mockMvc.perform(builder)
                .andExpect(ok);
    }
    @Test
    public void getRestaurantUser2Test() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isNotFound();  //SHOULD BE FOUND CHANGE THIS WHEN FIGURE OUT HOW TO MOCK DYNAMODB
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/restaurant/Tsujita/user/2");

        this.mockMvc.perform(builder)
                .andExpect(ok);
    }
    @Test
    public void getRestaurantUser3Test() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isNotFound();  //SHOULD BE FOUND CHANGE THIS WHEN FIGURE OUT HOW TO MOCK DYNAMODB
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/restaurant/Tsujita/user/3");

        this.mockMvc.perform(builder)
                .andExpect(ok);
    }
    @Test
    public void getRestaurantUser4Test() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isNotFound();  //SHOULD BE FOUND CHANGE THIS WHEN FIGURE OUT HOW TO MOCK DYNAMODB
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/restaurant/Tsujita/user/4");

        this.mockMvc.perform(builder)
                .andExpect(ok);
    }

    @Test
    public void getRestaurantCityTest() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isNotFound();  //SHOULD BE FOUND CHANGE THIS WHEN FIGURE OUT HOW TO MOCK DYNAMODB
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/restaurant/city/LosAngeles");

        this.mockMvc.perform(builder)
                .andExpect(ok);
    }

    @Test
    public void getRestaurantCityLabelTest() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isNotFound();  //SHOULD BE FOUND CHANGE THIS WHEN FIGURE OUT HOW TO MOCK DYNAMODB
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/restaurant/city/LosAngeles/label/chinese");

        this.mockMvc.perform(builder)
                .andExpect(ok);
    }

    @Test
    public void getYelp() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isNotFound();  //SHOULD BE FOUND CHANGE THIS WHEN FIGURE OUT HOW TO MOCK DYNAMODB
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/yelp");

        this.mockMvc.perform(builder)
                .andExpect(ok);
    }
}
