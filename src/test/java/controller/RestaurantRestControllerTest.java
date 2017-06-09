package test.java.controller;

import main.java.controller.RestaurantRestController;
import main.java.controller.ReviewRestController;
import main.java.implementations.RestaurantServiceImplementation;
import main.java.implementations.ReviewServiceImplementation;
import main.java.implementations.YelpServiceImplementation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:configuration.xml"})
//@WebMvcTest
public class RestaurantRestControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    private RestaurantServiceImplementation restaurantServiceImplementation;
    private YelpServiceImplementation yelpServiceImplementation;

    @Before
    public void setup() {

        StandaloneMockMvcBuilder builder = MockMvcBuilders.standaloneSetup(new RestaurantRestController(restaurantServiceImplementation, yelpServiceImplementation));
        this.mockMvc = builder.build();
    }

    @Test
    public void testControllers() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/yelp");

        this.mockMvc.perform(builder)
                .andExpect(ok);
    }

}
