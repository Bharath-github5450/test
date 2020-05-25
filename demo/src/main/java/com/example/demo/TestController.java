package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {
	
	@RequestMapping(value = "/a", method = RequestMethod.GET)
	public String getAllUsers() {
		//LOG.info("Getting all users.");
		return "Bharath";
	}
		

	@RequestMapping(value = "/calculatepv", method = RequestMethod.POST)
	public double addNewMobiles(@RequestBody Input user) {
		
		
		Integer fv=user.getFv();
		Integer r=user.getR();
		Integer n=user.getN();
		
		double temp = Math.pow((1+r),n);
		double returnVal=fv/temp;
		return returnVal;
		
		
		
	}
}
