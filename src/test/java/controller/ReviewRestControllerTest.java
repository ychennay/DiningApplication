package test.java.controller;

import main.java.config.PropertyConfiguration;
import main.java.controller.ReviewRestController;
import main.java.implementations.ReviewServiceImplementation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Leon on 6/8/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:configuration.xml"})
@WebMvcTest
public class ReviewRestControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Configuration
    @EnableAutoConfiguration
    public static class Config{
        ReviewServiceImplementation reviewServiceImplementation = new ReviewServiceImplementation();
        @Bean
        public ReviewRestController reviewRestController(){
            return new ReviewRestController(reviewServiceImplementation);
        }
    }


    @Before
    public void setup() {
//        ReviewServiceImplementation reviewServiceImplementation = new ReviewServiceImplementation();
//        StandaloneMockMvcBuilder builder = MockMvcBuilders.standaloneSetup(new ReviewRestController(reviewServiceImplementation));
//        this.mockMvc = builder.build();

        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getApiReviewsTest() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/reviews");

        this.mockMvc.perform(builder)
                .andExpect(ok);
    }

    @Test
    public void getApiReviewID1Test() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/reviews/1");

        this.mockMvc.perform(builder)
                .andExpect(ok);
    }
    @Test
    public void getApiReviewID2Test() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/reviews/2");

        this.mockMvc.perform(builder)
                .andExpect(ok);
    }
    @Test
    public void getApiReviewID3Test() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/reviews/3");

        this.mockMvc.perform(builder)
                .andExpect(ok);
    }
    @Test
    public void getApiReviewID4Test() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/reviews/4");

        this.mockMvc.perform(builder)
                .andExpect(ok);
    }


}
