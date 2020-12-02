package fr.isedia.demo.gcp.trace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TraceServiceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraceServiceOneApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}


}
