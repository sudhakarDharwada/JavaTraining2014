package com.binarysearch.search;
import java.util.Arrays;

import com.binarysearch.bean.Employee;
import com.binarysearch.rules.MyCondition;

public class BinarySearch {
	public boolean isExist(Object[] Elements, Object searchKey,
			MyCondition m) {
		Employee[] emp = (Employee[]) Elements;
		boolean result = false;
		Employee Key = (Employee) searchKey;
		Object RequiredElements[] = null;
		/*Checking the Searching whether it integer or not*/
		if ((Key.getEmpId()) != 0) {
			RequiredElements = new Integer[emp.length];
			for (int i = 0; i < emp.length; i++) {
				RequiredElements[i] = emp[i].getEmpId();
			}
			/*Checking the Searching whether it integer or not*/
		} else if ((Key.getEmpName()) != null) {
			RequiredElements = new String[emp.length];
			for (int i = 0; i < emp.length; i++) {
				RequiredElements[i] = emp[i].getEmpName();
			}
		} else {
			System.out.println(" Sorry Try Again...!");
			return false;
		}
		/*Binary Search Logic*/
		if ((Key.getEmpId() != 0) || (Key.getEmpName() != null)) {
			int condition = 0;
			int first = 0;
			int len = RequiredElements.length;
			Arrays.sort(RequiredElements);
			while (first < len) {
				int mid = (first + len) / 2;
				condition = m.checkCodition(RequiredElements[mid], searchKey);
				if (condition == 0) {
					return true;
				} else if (condition > 0) {

					len = mid;
				} else {
					first = mid + 1;
				}
			}
			return false;
		}
		return result;
	}
}