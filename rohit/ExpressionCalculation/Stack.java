package com.vl.stackoperations;

public class Stack 
{
	int[] operand;
	char[] operator;
	int pointer1=-1;
	int pointer2=-1;
	int capacity;
	public Stack(int capacity)
	{
		this.capacity=capacity;
		operand=new int[capacity];
		operator=new char[capacity];
	}
	public Stack(){
		
	}
	public void push(int element)
	{
			operand[++pointer1]=element;
	}
	public void push(char element)
	{
			operator[++pointer2]=element;
	}
	public int pop(int[] a)
	{
		return a[pointer1--];
	}
	public char pop(char[] a)
	{
		return a[pointer2--];
	}
}
