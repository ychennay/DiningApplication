package test.java.controller;

import main.java.controller.YelpFusionApiController;
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
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Leon on 6/9/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:configuration.xml"})
//@WebMvcTest
public class YelpFusionApiControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Configuration
    @EnableAutoConfiguration
    public static class Config{
        @Bean
        public YelpFusionApiController YelpFusionApiController(){
            return new YelpFusionApiController();
        }
    }

    @Before
    public void setup() {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getApiReviewsTest() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isNotFound();
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/yelp/search/");

        this.mockMvc.perform(builder)
                .andExpect(ok);
    }

}
