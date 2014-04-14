package com.vl.transaction;

public class Balance 
{
	int amount;
	public Balance(int amount)
	{
		this.amount=amount;
	}
	public void increment(int amount1)
	{
		amount+=amount1;
		//return amount;
	}
	public void decrement(int amount1)
	{
		amount-=amount1;
		//return amount;
	}

}
