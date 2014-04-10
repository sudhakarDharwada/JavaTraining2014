package com.temp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TimeCounting {


	public void empTimeCalculation(Map<Emp, Integer> m){

		Iterator<Entry<Emp, Integer>> i = m.entrySet().iterator();

		while(i.hasNext()){

			Entry<Emp,Integer> ee =i.next();

			Emp e =ee.getKey();
			System.out.println("Hashcode is");
			System.out.println(e.hashCode());
		}

	}

}
