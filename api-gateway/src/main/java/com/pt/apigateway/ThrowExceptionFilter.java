package com.pt.apigateway;

import com.netflix.zuul.ZuulFilter;

public class ThrowExceptionFilter extends ZuulFilter{

	@Override
	public Object run() {
		// TODO Auto-generated method stub
		throw new RuntimeException("post filter,exception");
		//return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

}
