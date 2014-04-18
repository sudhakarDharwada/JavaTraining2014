import java.util.*;
import java.util.Scanner;
import java.util.Stack;

  
public class ExpressionEvaluation {

   public static void main(String args[]) {
 
      Scanner in = new Scanner(System.in);
      ExpressionEvaluation expevl= new ExpressionEvaluation();      

      Stack<Character> operators = new Stack<Character>();
      Stack<Integer> operands = new Stack<Integer>();
 
      System.out.println("Enter the expression to be evaluated:\n");
      String expression = in.next();
   
      try {
        for (int i = 0;i < expression.length();i++){
           char ch = expression.charAt(i);
           int x=0;
    
           if( ch == '/' || ch =='*'){
              operators.push(ch);
              x=1;
           }

           else if( ch == '+' || ch =='-'){
              if(x==1){
                 char d=operators.pop();
                 
                 operands=expevl.evaluation(d,operands);
                 x=0;
                 operators.push(ch);
              }
              else{
                 operators.push(ch);
              }

           }
 
           else if(ch == '('){
              operators.push(ch);
           }
   
           else if(ch == ')'){
              while(!operators.isEmpty() && !operators.peek().equals(")")){
                 char g=operators.pop();
	         if(g!= '(')
                   operands=expevl.evaluation(g,operands);
	      }
           }
           else{
               operands.push(Character.getNumericValue(ch));			
           }

	}

      }

      catch (EmptyStackException e) {
         System.out.println("empty stack");
      }
  
 
      while(!operators.isEmpty()){
        char c=operators.pop();
        operands=expevl.evaluation(c,operands);	
      }
      System.out.println("The value of the expression is");
      System.out.println(operands.pop());
  }
  Stack<Integer> evaluation(char c,Stack<Integer> operands){
		int a=operands.pop();
		int b=operands.pop();
		switch(c){
			
                        case '+':	operands.push(a + b);
					break;
			
                        case '-':	operands.push(b - a);
					break;

			case '*':	operands.push(a * b);
					break;
			
                        case '/':	operands.push(b / a);
					break; 
			
                      
		}	
		return operands;
 	
 }	
}
