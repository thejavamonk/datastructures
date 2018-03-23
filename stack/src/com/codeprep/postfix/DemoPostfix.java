package com.codeprep.postfix;

import java.util.Scanner;

public class DemoPostfix {

	public static void main(String[] args) {
		
		String infix;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter infix expression : ");
		infix = scanner.nextLine();
		String postfix = infixToPostfix(infix);
		
		System.out.println("Postfix expression is : "+postfix);
		System.out.println("Value of expression : "+evaluatePostFix(postfix));
		scanner.close();
	}
	
	public static String infixToPostfix(String infix) {
		
		String postfix = new String();
		StackChar stack = new StackChar(20);
		char next, symbol;
		
		for(int i = 0; i < infix.length(); i++) {
			
			symbol = infix.charAt(i);
			
			if(symbol == ' ' || symbol == '\t') { /*ignore blanks and tabs*/
				continue;
			}
			
			switch(symbol) {
				
			case '(':
				stack.push(symbol);
				break;
			case ')':
				while ((next = stack.pop()) != '(' ) {
					postfix = postfix + next;
				}
				break;
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
			case '^':
				while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(symbol)) {
					postfix = postfix + stack.pop();
				}
				stack.push(symbol);
				break;
			default: /*if the symbol is an operand its added to postfix*/
				postfix = postfix + symbol;
			}
		}
		while(!stack.isEmpty()) {
			postfix = postfix + stack.pop();
		}
		return postfix;
	}
	
	public static int precedence(char symbol) {
		
		switch (symbol) {
		case '(':
			return 0;
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
		case '%':
			return 2;
		case '^':
			return 3;
		default:
			return 0;
		}
	}
	
	private static String evaluatePostFix(String postfix) {

		return null;
	}

}
