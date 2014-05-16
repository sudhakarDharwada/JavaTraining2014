package com.val.Timer;

import java.io.IOException;
import java.sql.Timestamp;


public class TimerExample 
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		String file=args[0];
		BirthDayTimer bdt=new BirthDayTimer();
		bdt.readFile(file);
		bdt.sendAlert();
	}
}
