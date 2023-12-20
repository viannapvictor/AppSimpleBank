package br.edu.infnet.AppSimpleBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppSimpleBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSimpleBankApplication.class, args);
	}

}
