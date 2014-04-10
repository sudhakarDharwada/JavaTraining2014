package com.temp;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class RemovingDuplicatesOfArray {


	public  void  removeDuplicatesInIntArray1(Map<Emp, Integer> m,Date date) {

		int array[] = new int[m.size()];
		int i=0;

		Iterator<Map.Entry<Emp, Integer>> it = m.entrySet().iterator();

		while(it.hasNext()){
			Entry<Emp,Integer> ee =it.next();

			if(ee.getKey().getDate().compareTo(date)==0)
				array[i]=ee.getKey().getId();
		
			i++;
		}

		
		int NumberOfEmp= removeDuplicatesInIntArray1(array);
		System.out.println(NumberOfEmp);

	}




	public  int  removeDuplicatesInIntArray1(int[] array) {

		

		int[] copy = Arrays.copyOf(array, array.length);
		Arrays.sort(copy);


		int count = 0;
		int previous = copy[0];
		for (int i = 1; i < array.length; ++i) {
			if (previous != copy[i]) {
				previous = copy[i];
				copy[++count] = previous;
			}
		}
		
		return (Arrays.copyOf(copy, count+1).length)-1;

	}


}
