package com.pt.apigateway;

import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ErrorExtFilter extends SendErrorFilter {

	@Override
	public int filterOrder() {
		return 30;  //大于ErrorFilter
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "error";
	}

	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		ZuulFilter failedFilter = (ZuulFilter)ctx.get("failed.filter");
		if(failedFilter != null && failedFilter.filterType().equals("post")) {
			return true;
		}
		return false;
	}
	
	
}
