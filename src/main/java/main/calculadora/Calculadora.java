package main.calculadora;

import java.util.Stack;

public class Calculadora {
    public Double performCalculation(String expresion) {
        // Dividir el texto en tokens (números y operadores)
        String[] tokens = expresion.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");

        // Pilas para números y operadores
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                numbers.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                char operator = token.charAt(0);
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(operator)) {
                    performOperation(numbers, operators);
                }
                operators.push(operator);
            }
        }

        while (!operators.isEmpty()) {
            performOperation(numbers, operators);
        }

        return numbers.pop();
    }

    private boolean isNumber(String token) {
        return token.matches("\\d+");
    }

    private boolean isOperator(String token) {
        return token.matches("[+\\-*/%]");
    }

    // Le asignamos un valor numérico a cada operador
    private int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '%' -> 3;
            default -> 0;
        };
    }

    // Realiza la operación correspondiente
    private void performOperation(Stack<Double> numbers, Stack<Character> operators) {
        double num2 = numbers.pop();
        double num1 = numbers.pop();
        char operator = operators.pop();
        double result = switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            case '%' -> num1 % num2;
            default -> 0;
        };

        numbers.push(result);
    }
}
