package com.val.Threadpool;

public class Account
{
	int amount;
	public Account(int amount)
	{
		this.amount = amount;
	}
	public  void withdraw(int money)
	{
		this.amount-=money;
	}
	public  void deposit(int money)
	{
		this.amount+=money;
	}
}
