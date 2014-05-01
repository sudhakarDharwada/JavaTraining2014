package com.vlabs.BankTxn.AccountDetails;
import java.util.HashMap;

public class AccountDetails {
	static HashMap<Integer, AccountDetails> map;
	private int AccountId;
	private double amount;

	public AccountDetails(int AccountId) {
		this.AccountId = AccountId;
	}

	public int getAccountId() {
		return AccountId;
	}

	public double getAmount() {
		return amount;
	}

	public AccountDetails deposite(double amount) {
		this.amount = this.amount + amount;
		return this;
	}

	public AccountDetails withdraw(double amount) {
		this.amount = this.amount - amount;
		return this;
	}
}