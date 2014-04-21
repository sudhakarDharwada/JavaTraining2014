package com.stack.example;
import java.util.Stack;
 
public class ExpressionEvaluation
{
    public  int evaluate(String expression)
    {
    	
        char[] data = expression.toCharArray();
        Stack<Integer> operands = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();
 
        for (int i = 0; i < data.length; i++)
        {
            if (data[i] >= '0' && data[i] <= '9')
            {
                StringBuffer buf = new StringBuffer();
                while (i < data.length && data[i] >= '0' && data[i] <= '9')
                    buf.append(data[i++]);
                operands.push(Integer.parseInt(buf.toString()));
            }
             else if (data[i] == '(')
                operators.push(data[i]);
             else if (data[i] == ')')
            {
                while (operators.peek() != '(')
                  operands.push(performCalculation(operators.pop(), operands.pop(), operands.pop()));
                operators.pop();
            }
             else if (data[i] == '+' || data[i] == '-' ||data[i] == '*' || data[i] == '/')
            {
                while (!operators.empty() && priority(data[i], operators.peek()))
                  operands.push(performCalculation(operators.pop(), operands.pop(), operands.pop()));
                 operators.push(data[i]);
            }
        }
         while (!operators.empty())
            operands.push(performCalculation(operators.pop(), operands.pop(), operands.pop()));
         return operands.pop();
    }
     public static boolean priority(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
 
    public static int performCalculation(char operator, int b, int a)
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
                throw new UnsupportedOperationException();
            return a / b;
        }
        return 0;
    }  
}