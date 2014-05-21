package com.vl.handlers;

public class MyThreadLocal
{
	public static final ThreadLocal<Boolean> MY_THREAD_LOCAL=new ThreadLocal<Boolean>();
	public static void set(Boolean isValidate)
	{
		MY_THREAD_LOCAL.set(isValidate);
	}
	public static Boolean get()
	{
		return MY_THREAD_LOCAL.get();
	}
	public static void unset()
	{
		MY_THREAD_LOCAL.remove();
	}
}