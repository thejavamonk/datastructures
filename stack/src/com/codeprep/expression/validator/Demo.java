package com.codeprep.expression.validator;

import java.util.Scanner;

public class Demo {
	
	public static void main(String[] args) {
		
		String expression;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter an expression with parentheses: ");
		expression = scanner.nextLine();
		
		if(isValid(expression)) {
			System.out.println("Valid expression");
		}
		else {
			System.out.println("Invalid expression");
		}
		scanner.close();
	}
	
	public static boolean isValid(String expr) {
		
		Stack stack = new Stack();
		char ch;
		
		for(int i = 0; i < expr.length(); i++) {
			
			if(expr.charAt(i) == '(' || expr.charAt(i) =='{' || expr.charAt(i) == '[') {
				stack.push(expr.charAt(i));
			}
			
			if(expr.charAt(i) == ')' || expr.charAt(i) =='}' || expr.charAt(i) == ']') {
				if(stack.isEmpty()) {
					System.out.println("Right parentheses are more than left parantheses");
					return false;
				}
			}
			else {
				ch = stack.pop();
				if(!matchParantheses(ch, expr.charAt(i))) {
					System.out.println("Mismatched parantheses are : ");
					System.out.println(ch + " and "+ expr.charAt(i));
					return false;
				}
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println("Balanced Parantheses");
			return true;
		}
		else {
			System.out.println("Left parantheses are more than right parantheses");
			return false;
		}
	}
	
	public static boolean matchParantheses(char leftPar, char rightPar) {
		
		if(leftPar == '[' && rightPar == ']') {
			return true;
		}
		if(leftPar == '{' && rightPar == '}') {
			return true;
		}
		if(leftPar == '(' && rightPar == ')') {
			return true;
		}
		return false;
	}
}
