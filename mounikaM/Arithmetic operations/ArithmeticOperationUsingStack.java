import java.util.Scanner;
import java.util.Stack;
import java.util.*;
class ArithmeticOperationUsingStack{
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a string to evaluate");
		String eval=s.next();
		Stack<Integer> operand=new Stack<Integer>();
		Stack<Character> operator=new Stack<Character>();
		boolean precedence=false;
		boolean open_parenthesis=false;
		char ch;
		ArithmeticOperationUsingStack cal=new ArithmeticOperationUsingStack();
		for(int i=0;i<eval.length();i++){
			ch=eval.charAt(i);
			switch(ch)
			{
				case '+': 
						if(precedence==true)
						{
							char a=operator.pop();
							//System.out.println(a);
							operand=cal.evaluation(a,operand);
							precedence=false;
							operator.push(ch);
						}
						else{
							operator.push(ch);	
						}
						break;
				case '-':
						if(precedence==true)
						{
							char b=operator.pop();
							operand=cal.evaluation(b,operand);
							precedence=false;
							operator.push(ch);
						}
						else{
							operator.push(ch);	
						}
						break;
				case '*':
						precedence=true;
						operator.push(ch);
						
						break;
				case '/':
						precedence=true;
						operator.push(ch);
						break;
				case '(':
						operator.push(ch);
						open_parenthesis=true;
						precedence=false;
						break;
				case ')':
						precedence=false;
						while(!operator.isEmpty() && open_parenthesis==true){
						char op1=operator.pop();
						if(op1!='(')
							operand=cal.evaluation(op1,operand);
						else
							open_parenthesis=false;
						}				
						break;
				default:
						operand.push(Character.getNumericValue(ch));			
			}
		}
		while(!operator.isEmpty())
		{
			char op=operator.pop();
			operand=cal.evaluation(op,operand);	
		}
		System.out.println("the value of the expression "+eval+"is");
		System.out.println(operand.pop());
	}
	Stack<Integer> evaluation(char op,Stack<Integer> operand)
	{
		int x=operand.pop();
		int y=operand.pop();
		switch(op){
			case '+':	
					operand.push(x+y);
					break;
			case '-':	
					operand.push(y - x);
					break;
			case '*':	
					operand.push(y * x);
					break;
			case '/':	
					operand.push(y/x);
					break; 
			default:		
		}	
		return operand;
	}	
}
