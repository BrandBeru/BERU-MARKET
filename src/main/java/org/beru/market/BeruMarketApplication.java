package org.beru.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class BeruMarketApplication {

	public static void main(String[] args) {
		System.out.println(LocalDateTime.now());
		SpringApplication.run(BeruMarketApplication.class, args);
	}

}
