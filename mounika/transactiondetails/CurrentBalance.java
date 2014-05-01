package transactiondetails;

public class CurrentBalance {
		int amount;
	public CurrentBalance(int amount){
	this.amount=amount;
	}
	public void deposit(int money){
	amount+=money;
	}
	public void withdraw(int money){
	amount-=money;
	}
	}

