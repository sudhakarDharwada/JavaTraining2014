package com.vl.threadpools.transaction;

public class Accno 
{
	int accno;
	public Accno(int no)
	{
		this.accno=no;
	}
	@Override
	public boolean equals(Object obj)
	{
		if(obj==null&&!(obj instanceof Accno))
			return true;	
		Accno k=(Accno)obj;
		return accno==k.accno;
	}
	@Override
	public int hashCode()
	{
		int hash = 1;
        hash = hash * 30 +accno;
        return hash;
	}

}
