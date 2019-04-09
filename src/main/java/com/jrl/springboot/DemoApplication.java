package com.jrl.springboot;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.jrl.springboot.controller.ProductController;
import com.jrl.springboot.service.ProductService;

@SpringBootApplication
//@ComponentScan(basePackageClasses = ProductService.class)
public class DemoApplication {
	
	
	@Value("${spring.application.name}")
	private String appName;
	
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	private static ApplicationContext ctx;

	
	@PostConstruct
	void start() {
//		TimeZone.setDefault(TimeZone.getTimeZone("PDT"));
	}
	
	public static void main(String[] args) {
		logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is an error message");
		ctx = SpringApplication.run(DemoApplication.class, args);
//		displayAllBeans();
		
	}
	
	public static void displayAllBeans() {
		String[] allBeanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(allBeanNames);
		for(String beanName : allBeanNames) {
			System.out.println(beanName);
		}
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
		
}
