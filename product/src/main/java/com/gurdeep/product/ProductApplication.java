package com.gurdeep.product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@OpenAPIDefinition(
		info = @Info(
				title = "Product Service Rest API Documentation",
				description = "Product Service Rest API",
				version = "v1",
				contact = @Contact(
						name = "Abc Sde",
						email = "support@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Sharepoint URL Product Service API",
				url = ""
		)
)
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
//		ApplicationContext context = SpringApplication.run(ProductApplication.class, args);
//		MyComponent__ myComponent = context.getBean(MyComponent__.class);
//		myComponent.getMessage();
	}

}
