package com.accountDetails;

import java.util.Date;


public class EmpAcc {

	int AccId;
	String operation;
	int amount;

	public int getAccId() {
		return AccId;
	}
	public void setAccId(int accId) {
		AccId = accId;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
