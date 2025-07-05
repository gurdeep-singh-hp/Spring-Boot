package com.gurdeep.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
//		ApplicationContext context = SpringApplication.run(ProductApplication.class, args);
//		MyComponent__ myComponent = context.getBean(MyComponent__.class);
//		myComponent.getMessage();
	}

}
