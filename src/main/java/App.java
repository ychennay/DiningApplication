package main.java;

import main.java.controller.ReviewRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.logging.Logger;

/**
 * Created by ychen4 on 5/4/2017.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"main.java", "main.resources"})
public class App {

    private static final Logger logger = Logger.getLogger(App.class.toString());


    public static void main(String[] args){
        SpringApplication.run(App.class, args);
    }
}
