package com.subhendu.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class LambdaDemo {
	private static List<String> operators = Arrays.asList("+", "-", "*", "/");
	private static String operator = "";
	private static int op1 = 0;
	private static int op2 = 0;

	public static void main(String[] args) {
		System.out.println("Please enter a command....");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command = "";
		try {
			command = br.readLine();
		} catch (IOException e) {
			System.err.println("Issue while reading line from console");
		}
		commandSplit(command.trim());
		Calculator calculator = new Calculator(op1, op2);
		switch(operator)
		{
		case "+":
			calculator.calculate((a, b) -> a + b);
			break;
			
		case "-":
			calculator.calculate((a, b) -> a - b);
			break;
			
		case "*":
			calculator.calculate((a, b) -> a * b);
			break;
			
		case "/":
			calculator.calculate((a, b) -> a / b);
			break;
			
		case "":
			System.err.println("Bad operator");
			break;
		}

	}

	private static void commandSplit(final String command) {
		operators.stream().forEach((x) -> {
			if (command.contains(x))
				operator = x;
		});
		try{
		op1 = Integer.valueOf(command.substring(0, command.indexOf(operator)));
		op2 = Integer.valueOf(command.substring(command.indexOf(operator) + 1));
		}
		catch(NumberFormatException e)
		{
			System.err.println("Error in parsing operands");
		}
	}
}
