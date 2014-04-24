package firstprogram;

import java.util.Stack;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EvaluateExpression {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		String expression;
		double answer;

		do {
			System.out.print("Your expression: ");
			expression = stdin.nextLine();
			try {
				answer = evaluate(expression);
				System.out.println("The value is " + answer);
			} catch (Exception e) {
				System.out.println("Error." + e.toString());
			}
		} while (query(stdin, "Another string?"));

		System.out.println("please enter another Expression.");
	}

	public static boolean query(Scanner input, String prompt) {
		String answer;

		System.out.print(prompt + " [Y or N]: ");
		answer = input.nextLine().toUpperCase();
		while (!answer.startsWith("Y") && !answer.startsWith("N")) {
			System.out.print("Invalid response. Please type Y or N: ");
			answer = input.nextLine().toUpperCase();
		}

		return answer.startsWith("Y");
	}

	public static double evaluate(String s) {
		Scanner input = new Scanner(s);
		Stack<Double> numbers = new Stack<Double>();
		Stack<Character> operations = new Stack<Character>();
		String next;
		char first;

		while (input.hasNext()) {
			if (input.hasNext(UNSIGNED_DOUBLE)) {
				next = input.findInLine(UNSIGNED_DOUBLE);
				numbers.push(new Double(next));
			} else {
				next = input.findInLine(CHARACTER);
				first = next.charAt(0);

				switch (first) {
				case '+': // Addition
				case '-': // Subtraction
				case '*': // Multiplication
				case '/': // Division
					operations.push(first);
					break;
				case ')': // Right parenthesis
					evaluateStackTops(numbers, operations);
					break;
				case '(': // Left parenthesis
					break;
				default: // Illegal character
					throw new IllegalArgumentException("Illegal character");
				}
			}
		}
		if (numbers.size() != 1)
			throw new IllegalArgumentException("Illegal input expression");
		return numbers.pop();
	}

	public static void evaluateStackTops(Stack<Double> numbers,
			Stack<Character> operations)

	{
		double operand1, operand2;

		if ((numbers.size() < 2) || (operations.isEmpty()))
			throw new IllegalArgumentException("Illegal expression");
		operand2 = numbers.pop();
		operand1 = numbers.pop();

		switch (operations.pop()) {
		case '+':
			numbers.push(operand1 + operand2);
			break;
		case '-':
			numbers.push(operand1 - operand2);
			break;
		case '*':
			numbers.push(operand1 * operand2);
			break;
		case '/':
			numbers.push(operand1 / operand2);
			break;
		default:
			throw new IllegalArgumentException("Illegal operation");
		}
	}

	// These patterns are from Appendix B of Data Structures and Other Objects.
	// They may be used in hasNext and findInLine to read certain patterns
	// from a Scanner.
	public static final Pattern CHARACTER = Pattern.compile("\\S.*?");
	public static final Pattern UNSIGNED_DOUBLE = Pattern
			.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");
}
