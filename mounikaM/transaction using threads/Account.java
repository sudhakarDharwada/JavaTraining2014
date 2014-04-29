package bank;

public class Account{
	double balance;
	String trans_type;
	public void withdrawl(double balance)
	{
    	this.balance =  this.balance-balance; 
    }
    public void deposit(double balance)
    {
    	this.balance = this.balance + balance;
    }
    
    public void setBalance(double balance,String trans_type){
    	if(trans_type.equalsIgnoreCase("deposit")){
    	    deposit(balance);
    	    
    	}
    	else {
    	    withdrawl(balance);
    	}
    }    
    public String toString(){
    	return ""+balance;
    }
}
