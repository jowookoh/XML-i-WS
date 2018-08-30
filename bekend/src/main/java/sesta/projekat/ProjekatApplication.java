package sesta.projekat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ProjekatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjekatApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:8081","http://localhost:8082","http://localhost:8083","http://localhost:8084","http://localhost:8085")
						.allowedMethods("GET", "POST", "DELETE", "OPTIONS", "PUT", "PATCH");
			}
		};
	}
}
