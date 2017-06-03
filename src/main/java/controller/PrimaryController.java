//package main.java.controller;
//
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * Created by ychen4 on 5/4/2017.
// */
//
//@Controller
//public class PrimaryController {
//
//    @RequestMapping(value = "/help", method = RequestMethod.GET)
//    public String help(){
//        System.out.println("GET called on help page");
//        return "help_page.html";
//    }
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String landing(){
//        System.out.println("GET called on index page");
//        return "landing.html";
//    }
//
//    @RequestMapping(value = "/restaurant", method = RequestMethod.GET)
//    public String restaurants(){
//        System.out.println("GET called on restaurant page");
//        return "restaurant_page.html";
//    }
//
//    @RequestMapping(value = "/review", method = RequestMethod.GET)
//    public String reviews(){
//        System.out.println("GET called on restaurant page");
//        return "review_page.html";
//    }
//
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public String users(){
//        System.out.println("GET called on user page");
//        return "user_page.html";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(){
//        System.out.println("GET called on login page");
//        return "login_page.html";
//    }
//
//}
