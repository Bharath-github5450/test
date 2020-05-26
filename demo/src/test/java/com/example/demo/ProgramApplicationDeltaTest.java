package com.example.demo;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

class ProgramApplicationDeltaTest {

	@Test
	public void getDelta() {

		double Pv1 = 0;
		double Pv2 = 0 ;
		List<Input> inputs = new ArrayList<Input>();
		Input input1 = new Input();
		Input input2 = new Input();

		input1.setFv(1000);
		input1.setN(5);
		input1.setR(35);
		input2.setFv(350);
		input2.setN(4);
		input2.setR(25);
		inputs.add(input1);
		inputs.add(input2);

		if (null!=inputs  && inputs.size()==2) {

			if (null!=inputs.get(0) && null!=inputs.get(1))
			{
				Pv1 = inputs.get(0).getFv()/(Math.pow((1+inputs.get(0).getR()),inputs.get(0).getN()));

				System.out.printf("Calculated Present Value from Data Set 1 :%f\n", Pv1);
				Pv2 = inputs.get(1).getFv()/(Math.pow((1+inputs.get(1).getR()),inputs.get(1).getN()));
				System.out.printf("Calculated Present Value from Data Set 2 : %f\n", Pv2);
				System.out.printf("Delta : %f\n", (Pv1-Pv2));
				
			}

		}

	}

}
