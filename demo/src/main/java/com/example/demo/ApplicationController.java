package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController

public class ApplicationController {

	@RequestMapping(value = "/a", method = RequestMethod.GET)
	public String getAllUsers() {
		//LOG.info("Getting all users.");
		return "Bharath";
	}


	@RequestMapping(value = "/calculatepv", method = RequestMethod.POST)
	public String getCalculatePV(@RequestBody Input user) {


		Integer fv=user.getFv();
		//finalValue
		Integer r=user.getR();
		Integer n=user.getN();

		double temp = Math.pow((1+r),n);
		double returnVal=fv/temp;
		//DecimalFormat df= new DecimalFormat ("##.00");
		String returnValurString= String.format("%.2f",returnVal);
		StringBuilder sb = new StringBuilder();
		sb.append("Future value  : $"+fv+"\n");
		sb.append("Rate : "+r+"%\n");
		sb.append("Term : "+n+" years\n");
		sb.append("Present value is $"+returnValurString);
		return sb.toString();



	}

	@RequestMapping(value = "/getDelta", method = RequestMethod.POST)
	public String getDelta(@RequestBody List<Input> inputs) {

		double Pv1 = 0;
		double Pv2 = 0;
		double delta = 0;

		if (null!=inputs  && inputs.size()==2) {
			//if (null!=inputs  && inputs.size()>0) 

			if (null!=inputs.get(0) && null!=inputs.get(1))
			{
				Pv1 = inputs.get(0).getFv()/(Math.pow((1+inputs.get(0).getR()),inputs.get(0).getN()));
				Pv2 = inputs.get(1).getFv()/(Math.pow((1+inputs.get(1).getR()),inputs.get(1).getN()));
				delta = Pv1 - Pv2;
			}

		}

		String returnDeltaString= String.format("%.2f",delta);
		StringBuilder sbDelta = new StringBuilder();
		sbDelta.append("Present value 1 : $"+Pv1+"\n");
		sbDelta.append("Present value 2 : $"+Pv2+"\n");
		sbDelta.append("Delta : $"+returnDeltaString);
		return sbDelta.toString();

		//return "Delta between two present values : "+delta;
		//return "Value of fv in list1 "+Pv1+" Value of fv in list2 "+Pv2;	
	}


}
