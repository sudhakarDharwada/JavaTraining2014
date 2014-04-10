package com.binarysearch.rules;

import com.binarysearch.bean.Employee;
import com.binarysearch.interfaces.Criteria;

public class MyCondition implements Criteria {
	/*This method Checks the Condition*/
	public int checkCodition(Object Element, Object searchKey) {
		int status = 1;

		Employee key = (Employee) searchKey;
		if ((key.getEmpId()) != 0) {
			Integer Id = (Integer) Element;
			if (Id == key.getEmpId()) {
				status = 0;
				return status;
			} else if (Id > key.getEmpId()) {
				status = 1;
				return status;
			} else {
				status = -1;
				return status;
			}
		} else if ((key.getEmpName()) != null) {
			String Name = (String) Element;
			status = Name.compareToIgnoreCase(key.getEmpName());
			return status;
		} else {
			System.out.println("sorry try agin");
		}
		return 1;
	}

}
