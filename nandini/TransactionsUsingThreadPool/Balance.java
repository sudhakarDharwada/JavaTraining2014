package com.vl.ThreadPool;

public class Balance {
    double amount;
    String type;
    
    public void withdraw(double amount){
    	this.amount = this.amount - amount; 
    }
    public void deposit(double amount){
    	this.amount = this.amount + amount;
    }
    
    public void setBalance(double amount,String type){
    	if(type.equalsIgnoreCase("deposit")){
    	    deposit(amount);
    	}
    	else {
    	    withdraw(amount);
    	}
    }
    public String toString(){
    	return ""+amount;
    }
}
