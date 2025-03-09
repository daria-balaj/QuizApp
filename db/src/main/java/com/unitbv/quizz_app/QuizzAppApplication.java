package com.unitbv.quizz_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class QuizzAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizzAppApplication.class, args);
	}

}
