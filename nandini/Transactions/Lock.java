package com.vl.bank;

public class Lock {
    protected int id;
    public Lock(int id){
        this.id = id;
    }
    //To override the hashCode
    @Override
    public int hashCode(){
    	return id;
    }
    //To override the equals
    @Override
    public boolean equals(Object obj){
        if(obj !=null && obj instanceof Lock){
            Lock l = (Lock)obj;
            if(id == l.id){
                return true;
            }
        }
        return false;
    }
}