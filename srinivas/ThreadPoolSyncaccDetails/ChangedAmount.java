package com.ThreadPoolSyncaccDetails;

public class ChangedAmount {

	public int amount;
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
