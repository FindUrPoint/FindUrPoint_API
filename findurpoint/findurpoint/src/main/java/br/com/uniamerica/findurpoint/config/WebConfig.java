package br.com.uniamerica.findurpoint.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebConfig extends WebMvcConfigurerAdapter {

    public void addCorsMappings(CorsRegistry registry){

        registry.addMapping("/**").allowedMethods("*");
    }
}
