package afferolab.chalenge.papelaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@ComponentScan("afferolab.chalenge.papelaria.service")
@ComponentScan("afferolab.chalenge.papelaria.repository")
@ComponentScan("afferolab.chalenge.papelaria.entity")
@ComponentScan("afferolab.chalenge.papelaria.controller")
@SpringBootApplication
public class PapelariaAfferoLabApplication {
	
	
    
	public static void main(String[] args) {
		SpringApplication.run(PapelariaAfferoLabApplication.class, args);
		 
	}

}
