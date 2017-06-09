package main.java.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;
import org.springframework.web.bind.annotation.*;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Collections;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by CrazyAzianFool on 6/8/17.
 */
//@Controller
//public class RegisterController {
//
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public String load_register(){
//        System.out.println("GET called on the registration page");
//        return "registration";
//    }
//
//}

@Controller
public class RegisterController {

    /**
     * this is the controller for the registration page
     * The endpoint is specified at /registration
     * when a GET message is used respond with a system print and return the registration.html
     *
     * when a POST message is used (by users entering their information) pull this information to create a new user (in progress)
     *
     * @return
     */

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String load_register(){
        System.out.println("GET called on the registration page");
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String post_register(){
        System.out.println("POST called on the registration page");
        return "registration";
    }

}