package edu.globant;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class Main extends WebMvcAutoConfiguration{
	
	// Local logger
	protected Logger logger;

	public static void main(String[] args) {
		new Main().runAsJavaApplication(args);
	}
	
	public void runAsJavaApplication(String[] args){
		logger = LoggerFactory.getLogger(getClass());
		SpringApplication.run(Main.class, args);
		logger.info("Go to this URL: http://localhost:8080/");
	}

}
