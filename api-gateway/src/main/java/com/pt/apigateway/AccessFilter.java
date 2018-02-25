package com.pt.apigateway;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(AccessFilter.class);
	
	@Override
	public Object run() {
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
		
		String accessToken = request.getParameter("accessToken");
		
		if(accessToken == null||!accessToken.equals("gehb")) {
			log.warn("access token is empty");
//			ctx.setSendZuulResponse(false);
//			ctx.setResponseStatusCode(401);
			ctx.set("error.status_code", HttpServletResponse.SC_UNAUTHORIZED);
			ctx.set("error.exception", new Exception("用户没有权限"));
			return null;
		}
		log.info("access token ok");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
