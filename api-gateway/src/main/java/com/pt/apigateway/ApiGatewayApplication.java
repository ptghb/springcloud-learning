package com.pt.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.netflix.zuul.FilterProcessor;

@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		FilterProcessor.setProcessor(new ExtFilterProcessor());
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
	
	@Bean
	public ThrowExceptionFilter throwExceptionFilter() {
		return new ThrowExceptionFilter();
	}
	
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	
	@Bean
	public 	ErrorExtFilter errorExtFilter() {
		return new ErrorExtFilter();
	}
	
}
