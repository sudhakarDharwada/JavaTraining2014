package org.bank.transaction;

public class AccountStatus {
	int amount;
	public AccountStatus(int amount){
		this.amount=amount;
	}
	public void deposit(int money){
		amount+=money;
	}
	public void withdraw(int money){
		amount-=money;
	}

}
