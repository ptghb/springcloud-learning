package com.pt.eurekafeign;

import org.springframework.stereotype.Component;

import com.pt.eurekaapi.User;

@Component
public class ComputeFallback implements ComputeClient {

	@Override
	public Integer add(Integer a, Integer b) {
		return 0;
	}

	@Override
	public String getUser(User user) {
		return "error";
	}
}