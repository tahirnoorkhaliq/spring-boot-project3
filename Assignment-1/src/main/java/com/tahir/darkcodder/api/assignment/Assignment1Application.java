package com.tahir.darkcodder.api.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Assignment1Application {

	public static void main(String[] args) {	
		
		   ConfigurableApplicationContext ctx = SpringApplication.run(Assignment1Application.class, args);			
	        System.out.println("Number of beans --> " + ctx.getBeanDefinitionCount());
	        String[] beanNames = ctx.getBeanDefinitionNames(); // get beans
	        for (String beanName : beanNames) {
	            System.out.println("Bean --> "+ beanName); // print bean
	        }
	    }
}
