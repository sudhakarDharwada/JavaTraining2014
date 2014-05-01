package com.syncaccdetails;



public class EmpAcc {

	int AccId;
	Object obj;
	
	EmpAcc(int AccId){
		this.AccId = AccId;
	}

	public int getAccId() {
		return AccId;
	}
	public void setAccId(int accId) {
		AccId = accId;
	}
	
	@Override
	public int hashCode(){
		
		return  AccId;
	}
	
	@Override
	public boolean equals(Object obj){
		
		if(obj !=null && obj instanceof EmpAcc){
			EmpAcc l = (EmpAcc)obj;
            if(AccId == l.AccId){
                return true;
            }
        }
        return false;
	}
}
