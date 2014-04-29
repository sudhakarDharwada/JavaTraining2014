package com.snapfish.threads.beans;

import java.util.Hashtable;

public class AccountRecord {
	static Hashtable<Integer, AccountRecord> map;
	private int AccountId;
	private double amount;

	public AccountRecord(int AccountId) {
		this.AccountId = AccountId;
	}

	public int getAccountId() {
		return AccountId;
	}

	public double getAmount() {
		return amount;
	}

	public static AccountRecord setAccountRecord(Integer UserId,
			Hashtable<Integer, AccountRecord> set) {
		synchronized (UserId) {
			map = set;
			AccountRecord obj = null;
			if (map.containsKey(UserId)) {
				obj = map.get(UserId);
			} else {
				obj = new AccountRecord(UserId);
				map.put(UserId, obj);
			}
			return obj;
		}
	}

	public AccountRecord addValue(double amount) {
		this.amount = this.amount + amount;
		return this;
	}

	public AccountRecord diffValue(double amount) {
		this.amount = this.amount - amount;
		return this;
	}
}
