import java.util.*;
public class StackEvaluation{
	public static void main(String args[])throws NullPointerException
	{	
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the Expression to be evaluate");
		String input=sc.next();
		System.out.print(input);
		Stack<Integer> operands = new Stack<Integer>();
		Stack<Character> operators=new Stack<Character>();
		int result=0; 
		StackEvaluation se=new StackEvaluation();
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
					
					case '+':if(previousChar==true){
						char x=operators.pop();
						operands=se.methodCal(x,operands);
					}
					else
						operators.push(ch);
					break;
					
					case '-':if(previousChar==true){
						char y=operators.pop();
						operands=se.methodCal(y,operands);
					}
					else
						operators.push(ch);					
					break;
					
					case '(': operators.push(ch);
					break;
							
					case ')':
					while(!operators.isEmpty() && !operators.peek().equals(")")){
						char res=operators.pop();
						if(res!= '(')
							operands=se.methodCal(res,operands);
					}
					break;
					
					default: operands.push(Character.getNumericValue(ch));		
					break;
				}
			}
		}
		while(!operators.isEmpty()){
			char c=operators.pop();
			operands=se.methodCal(c,operands);
		}
		System.out.println("Result of Evaluated Expression is"+operands.pop());
	}
	Stack<Integer> methodCal(char c,Stack<Integer> operands)
	{
		int a=operands.pop();
		int b=operands.pop();
			switch(c)
			{
				case '*':System.out.print(operands.push(a*b));
				break;
				case '/':operands.push(b/a);
				break;
				case '+':operands.push(a+b);
				break;
				case '-':operands.push(b-a);
				break;
			}
		return operands;
	}
}	
		
	
