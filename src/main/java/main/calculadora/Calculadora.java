package main.calculadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Calculadora {
    public Double performCalculation(String expresion) {
        // Dividir el texto en tokens (números y operadores)
        String[] tokens = expresion.split("(?<=[+\\-*/%()])|(?=[+\\-*/%()])");

        // Insertar tokens de multiplicación implícitos
        String[] correctedTokens = insertMultiplicationTokens(tokens);

        // Pilas para números y operadores
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        // Recorrer los tokens
        for (int i = 0; i < correctedTokens.length; i++) {
            // Si el token es un signo menos y está al principio o después de un operador, se considera un número negativo
            String token = correctedTokens[i];
            if (token.equals("-") && (i == 0 || correctedTokens[i - 1].matches("[+\\-*/%(]"))) {
                token += correctedTokens[i + 1];
                i++;
            }
            // Si el token es un número, se agrega a la pila de números
            if (isNumber(token)) {
                numbers.push(Double.parseDouble(token));

            // Si el token es un operador, se agrega a la pila de operadores
            } else if (isOperator(token)) {
                char operator = token.charAt(0);
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(operator) && !operators.peek().equals('(')) {
                    performOperation(numbers, operators);
                }
                operators.push(operator);

            // Si el token es un paréntesis, se agrega a la pila de operadores
            } else if (isParenthesis(token)) {
                if (token.equals("(")) {
                    operators.push('(');
                } else {
                    while (!operators.isEmpty() && !operators.peek().equals('(')) {
                        performOperation(numbers, operators);
                    }
                    operators.pop();
                }
            }
        }

        while (!operators.isEmpty()) {
            performOperation(numbers, operators);
        }

        return numbers.pop();
    }

    private boolean isNumber(String token) {
        return token.matches("^-?\\d+(\\.\\d+)?$"); // Números enteros y decimales positivos y negativos
    }

    private boolean isOperator(String token) {
        return token.matches("[+\\-*/%]");
    }

    private boolean isParenthesis(String token) {
        return token.matches("[()]");
    }

    // Asignar un valor numérico a cada operador
    private int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '%' -> 3;
            default -> 0;
        };
    }

    // Realizar la operación correspondiente
    private void performOperation(Stack<Double> numbers, Stack<Character> operators) {
        if (operators.peek().equals('(')) {
            operators.pop();
            return;
        }

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

    private String[] insertMultiplicationTokens(String[] tokens) {
        List<String> newTokens = new ArrayList<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            newTokens.add(token);

            if (i < tokens.length - 1) {
                String nextToken = tokens[i + 1];
                if (shouldInsertMultiplication(token, nextToken)) {
                    newTokens.add("*");
                }
            }
        }

        return newTokens.toArray(new String[0]);
    }

    private boolean shouldInsertMultiplication(String currentToken, String nextToken) {
        return ((isNumber(currentToken) &&  nextToken.equals("(")) || (currentToken.equals(")") && isNumber(nextToken)));
    }

}
