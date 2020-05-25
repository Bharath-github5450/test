package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProgramApplicationTests {

	@Test
	void testForPV() {
		Integer fv=1000;
		Integer r=10;
		Integer n=5;

		double temp = Math.pow((1+r),n);
		double returnVal=fv/temp;
		//DecimalFormat df= new DecimalFormat ("##.00");
		String returnValurString= String.format("%.2f",returnVal);
		StringBuilder sb = new StringBuilder();
		sb.append("Future value  : $"+fv+"\n");
		sb.append("Rate : "+r+"%\n");
		sb.append("Term : "+n+" years\n");
		sb.append("Present value is $"+returnValurString);
		System.out.println( sb.toString());
	}

}
