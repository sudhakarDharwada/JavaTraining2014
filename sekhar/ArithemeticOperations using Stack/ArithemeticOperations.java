import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class ArithemeticOperations
{
	public static int  infix(String expression)
	{	
		char[] tokens = expression.toCharArray();
		Stack<Integer> operandStack = new Stack<Integer>();
		Stack<Character> operatorStack = new Stack<Character>();
		for (int i = 0; i < tokens.length; i++)
		{	 
			if (tokens[i] == ' ')
				continue;
			if (tokens[i] >= '0' && tokens[i] <= '9')
			{
				StringBuffer sbuf = new StringBuffer();//here we are using sbuf becoz if our digit is more than one digit we can append all those digits and push into OperandStack
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sbuf.append(tokens[i++]);
				operandStack.push(Integer.parseInt(sbuf.toString()));
			}
			else if (tokens[i] == '(')
				operatorStack.push(tokens[i]);
			else if (tokens[i] == ')')
			{
				while (operatorStack.peek() != '(')
					operandStack.push(operation(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
				operatorStack.pop();
			}
			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/')
			{
				while (!operatorStack.empty() && precedence(tokens[i], operatorStack.peek()))
					operandStack.push(operation(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
				operatorStack.push(tokens[i]);
			}
		}
		while (!operatorStack.empty())
			operandStack.push(operation(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
		return operandStack.pop();
	}

	public static boolean precedence(char operator1, char operator2)
	{
		if (operator2 == '(' || operator2 == ')')
			return false;
		if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-'))
			return false;
		else
			return true;
	}
	public static int operation(char operator, int b, int a)
	{
		switch (operator)
		{
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new
				UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		}
		return 0;
	}
	public static void main(String[] args)
	{	
		String input = "";
		System.out.print("Enter an infix expression with spaces like (2 + 2 * 5): ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {						
			input = in.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error getting input!");
		}	
		System.out.println(input+"="+infix(input));
	}

}
