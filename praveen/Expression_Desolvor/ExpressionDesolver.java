package com.training.frominfix.toprefix;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class ExpressionDesolver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter The Expression:");
		String exp[] = scanner.nextLine().split(" ");
		ExpressionDesolver ed =new ExpressionDesolver();
		ed.desovler(exp,new Stack<Double>(),new Stack<String>());
		
	}

	public void desovler(String[] exp, Stack<Double> vals,
			Stack<String> ops) {
		for (int i = 0; i < exp.length; i++) {
			String s = exp[i];
			if (s.equals("(")) {
			} else if (s.equals("+")) {
				String isout = ops.push(s);
			} else if (s.equals("-")) {
				ops.push(s);
			} else if (s.equals("*") || s.equals("/")) {
				if (ops.empty()) {
					if (s.equals("*")) {
						vals.push(vals.pop() * Double.parseDouble(exp[i + 1]));
						i++;
						continue;
					} else if (s.equals("/")) {
						vals.push(vals.pop() / Double.parseDouble(exp[i + 1]));
						i++;
						continue;
					}
				} else {
					if (ops.peek().equals("+") || ops.peek().equals("-")) {
						if (s.equals("*")) {
							vals.push(vals.pop()* Double.parseDouble(exp[i + 1]));
							i++;
							continue;
						} else if (s.equals("/")) {
							vals.push(vals.pop()/ Double.parseDouble(exp[i + 1]));
							i++;
							continue;
						}
					} else {
						ops.push(s);
					}
				}
			} else if (s.equals(")")) {
			} else {
				vals.push(Double.parseDouble(s));
			}
		}
		LastCal(ops,vals);
	}

	public void LastCal(Stack<String> ops, Stack<Double> vals) {
		if(ops.empty())
		{
			System.out.print("\n\nThe Final Value:"+vals.pop());
		}
		else {
			Iterator<String> its = ops.iterator();
			while (its.hasNext()) {
				if(ops.pop().equals("+"))
				{
					vals.push(vals.pop()+vals.pop());
				}
				else if (ops.pop().equals("-")) {
					vals.push(vals.pop()-vals.pop());
				}
				its=ops.iterator();
			}
			LastCal(ops, vals);
		}
	}
	
}

