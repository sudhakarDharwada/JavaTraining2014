package com.stack.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StakMain {

	public static void main(String[] args)
	{
		ExpressionEvaluation ee=new ExpressionEvaluation();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String data;
		try {
			System.out.println("Enter Expression to evaluate");
			data = br.readLine();
			System.out.println(ee.evaluate(data));
		} catch (IOException e) {
			e.printStackTrace();
		}catch(UnsupportedOperationException a){
			System.out.println("cann't divide something by zero");
		}
	}

}


