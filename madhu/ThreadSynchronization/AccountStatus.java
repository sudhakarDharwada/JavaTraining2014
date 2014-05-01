package org.thread.sync;

public class AccountStatus  {
	int amount;
	
	public AccountStatus(int amount){
		this.amount=amount;
		//System.out.println("ac"+this.amount);
	}
	public void deposit(int money){
		amount+=money;
		//System.out.println("updated"+amount);
	}
	public void withdraw(int money){
		amount-=money;
	}
	
}
