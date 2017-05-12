package main.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ychen4 on 5/4/2017.
 */
//@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class App extends SpringBootServletInitializer{

//    private static final Logger logger = Logger.getLogger(App.class.toString());

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(appClass);
    }

    private static Class<App> appClass = App.class;

}


