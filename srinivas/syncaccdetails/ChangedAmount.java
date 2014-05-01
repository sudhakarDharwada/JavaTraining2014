package com.syncaccdetails;

public class ChangedAmount {

	int amount;
	public ChangedAmount( int amount){

		this.amount = amount;
	}
	public void deposit(int amount1)
	{
		amount+=amount1;
	}
	public void deduct(int amount1)
	{
		amount-=amount1;
	}


}
