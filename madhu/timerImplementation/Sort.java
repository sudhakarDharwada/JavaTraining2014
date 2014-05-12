package org.thread.timerImplementation;

import java.util.Comparator;

class Sort implements Comparator<BirthdayRemainder>{

	public int compare(BirthdayRemainder raminder1, BirthdayRemainder remainder2) {

		return raminder1.timestamp.compareTo(remainder2.timestamp);
	}	
}
