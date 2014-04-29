package com.snapfish.threads.beans;

import java.util.Hashtable;
public class AccountRecord {
	static Hashtable<Integer,AccountRecord> map;
	private int AccountId;
	private double amount;
	public AccountRecord(int AccountId) {
		this.AccountId=AccountId;
	}
	public int getAccountId() {
		return AccountId;
	}
	public void setAccountId(int accountId) {
		AccountId = accountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
        /*this method creates an object to every unique userId and sets to hashtable*/
	public static synchronized AccountRecord setAccountRecord(Integer UserId,Hashtable<Integer, AccountRecord> set)
	{
		map=set;
		AccountRecord obj=null;
		if(map.containsKey(UserId))
		{
			obj=map.get(UserId);
		}
		else {
			obj=new AccountRecord(UserId);
			map.put(UserId,obj);
		}
		return obj;
	}
        /*this method added the amount*/
	public AccountRecord addValue(double amount) {
		this.amount=this.amount+amount;
		return this;
	}
        /*this method substracts  the amount*/
	public AccountRecord diffValue(double amount) {
		this.amount=this.amount-amount;
		return this;
	}
	public static void displayAll() {
		System.out.println("Hashset:"+map);
		
	}
}
