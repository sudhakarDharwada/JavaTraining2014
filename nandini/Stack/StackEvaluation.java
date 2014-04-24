import java.util.*;
public class Stack1{
	public static void main(String args[])throws NullPointerException
	{	
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the Expression to be evaluate");
		String input=sc.next();
		System.out.print(input);
		Stack1 se=new Stack1();
		Stack<Integer> operands = new Stack<Integer>();
		Stack<Character> operators=new Stack<Character>();
		int result=se.method(input, operands, operators);
		System.out.println("The result is"+result);
		
	}
	public int method(String input,Stack<Integer> operands,Stack<Character> operators)
	{	
		boolean previousChar=false;
		for(int i=0;i<input.length();i++)
		{
			char ch=input.charAt(i);
			if(ch > '0' && ch <='9')
			{
				operands.push((Character.getNumericValue(ch)));
			}
			else
			{
				switch(ch)
				{
					case '*': operators.push(ch);
					previousChar=false;
					break;
					
					case '/':operators.push(ch);
					previousChar=false;
					break;
					
					case '+':
					try
					{
						while(operators.peek().equals('*') || operators.peek().equals('/'))	
						{
							char x=operators.pop();
							operands=methodCal(x,operands);
					
						}
					}
					catch(Exception e)
						{ }
						operators.push(ch);
						break;
					
					case '-': try
					{
						while(operators.peek().equals('*') || operators.peek().equals('/'))	
						{
							char y=operators.pop();
							operands=methodCal(y,operands);
					
						}
					}
					catch(Exception e)
						{}
						operators.push(ch);
						break;
					
					case '(': operators.push(ch);
					break;
							
					case ')':
					while(!operators.isEmpty() && !operators.peek().equals(")")){
						char res=operators.pop();
						if(res!= '(')
							operands=methodCal(res,operands);
						
					}
					break;
					
					default: operands.push(Character.getNumericValue(ch));		
					break;
				}
			}
		}
	
		while(!operators.isEmpty()){
			char c=operators.pop();
			operands=methodCal(c,operands);
		}
		return operands.pop();
	}

	Stack<Integer> methodCal(char c,Stack<Integer> operands)
	{
		int a=operands.pop();
		int b=operands.pop();
		int d=0;
			switch(c)
			{
				case '*':d=a*b;
						operands.push(d);
				break;
				case '/':operands.push(b/a);
				break;
				case '+':
						operands.push(a+b);
				break;
				case '-':
					operands.push(b-a);
					break;
			}
		return operands;
	}
}	
		
	
