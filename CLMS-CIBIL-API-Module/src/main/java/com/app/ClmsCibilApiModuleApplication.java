package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.context.annotation.Bean;
=======
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
>>>>>>> branch 'master' of https://github.com/shubhamkrmahto/CarLoan_CIBIL.git

@SpringBootApplication
@EnableDiscoveryClient
public class ClmsCibilApiModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClmsCibilApiModuleApplication.class, args);
	}

}
