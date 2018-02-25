package com.pt.computeribbon;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

@Service
public class ConsumerService {
	
    @Autowired
    RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod="addFallback")
    public String add() {
    	return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    }
    
    public String addFallback() {
    	return "error";
    }
    
    @HystrixCommand(fallbackMethod="addFallback")
    public Future<String> addAsync() {
    	
    	return new AsyncResult<String>() {

			@Override
			public String invoke() {
				return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
			}
    		
    	};
    }

}
