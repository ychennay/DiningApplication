package main.java;

import main.java.config.PropertyConfiguration;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Created by ychen4 on 5/4/2017.
 */

@SpringBootApplication
@EnableEurekaServer
public class App extends SpringBootServletInitializer{

 private static final Logger logger = Logger.getLogger(App.class.toString());

    public static void main(String[] args) throws Exception {

        String configFile = "configuration.xml";
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext(configFile);
        PropertyConfiguration configuration = (PropertyConfiguration) context.getBean("propertyConfiguration");

        SpringApplication.run(App.class, args);




    }



    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(appClass);
    }

    private static Class<App> appClass = App.class;

}


