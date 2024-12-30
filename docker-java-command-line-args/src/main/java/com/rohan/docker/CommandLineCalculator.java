package com.rohan.docker;

public class CommandLineCalculator {

    public static void main(String[] args) {
    	
        if (args.length != 3) {
            System.out.println("Usage: java CommandLineCalculator <operator> <operand1> <operand2>");
            System.out.println("Operator: +, -, *, or /");
            return;
        }

        String operator = args[0];
        int operand1, operand2;
        try {
            operand1 = Integer.parseInt(args[1]);
            operand2 = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Both operands must be integers.");
            return;
        }

        int result;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    return;
                }
                result = operand1 / operand2;
                break;
            default:
                System.out.println("Error: Invalid operator. Use +, -, *, or /.");
                return;
        }

        System.out.println("Result: " + result);
    }
}
