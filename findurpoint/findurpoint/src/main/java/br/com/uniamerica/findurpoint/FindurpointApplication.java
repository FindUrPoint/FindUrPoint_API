package br.com.uniamerica.findurpoint;

import br.com.uniamerica.findurpoint.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FindurpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindurpointApplication.class, args);
	}


	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebConfig(){
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

}
