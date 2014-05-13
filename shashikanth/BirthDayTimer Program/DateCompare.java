package com.val.Timer;

import java.util.Comparator;

public class DateCompare implements Comparator<BirthDayDetails>
{
	public int compare(BirthDayDetails o1, BirthDayDetails o2) 
	{
		return o1.getDateTime().compareTo(o2.getDateTime());
	}
	
}
