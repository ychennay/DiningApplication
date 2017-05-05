package main.java.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ychen4 on 5/4/2017.
 */

@Controller
public class MainController {

    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String help(){
        System.out.println("GET called on help page");
        return "html/help.html";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String landing(){
        System.out.println("GET called on index page");
        return "landing.html";
    }


}
