package com.pt.eurekafeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pt.eurekaapi.User;

@RestController
public class ComputeController {
	
    @Autowired
    ComputeClient computeClient;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(10, 20);
    }
    
    @RequestMapping(value = "/user" ,method = RequestMethod.POST)
    public String getUser() {
    	User user = new User();
    	user.setName("gehb");
    	user.setAge(28);
    	return computeClient.getUser(user);
    }

}