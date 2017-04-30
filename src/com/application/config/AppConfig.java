package com.application.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by ychen4 on 4/30/2017.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.application")
public class AppConfig {

}
