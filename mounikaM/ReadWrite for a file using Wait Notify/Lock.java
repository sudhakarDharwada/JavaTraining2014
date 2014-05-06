package com.vl.ReadWriteLocks;

public class Lock
{
	protected int id;
    public boolean equals(Object obj)
    {
        if(obj !=null && obj instanceof Lock)
        {
            Lock l = (Lock)obj;
            if(id == l.id){
                return true;
            }
        }
        return false;
    }
}

