package main.calculadora;
import java.util.Stack;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculadoraController {

    public Button number0;
    public Button number1;
    public Button number2;
    public Button number3;
    public Button number4;
    public Button number5;
    public Button number6;
    public Button number7;
    public Button number8;
    public Button number9;
    public Button plus;
    public Button minus;
    public Button equal;
    public Label screen;

    public void sumar(){
        String text = screen.getText();
        screen.setText(text + "+");
    }

    public void restar(){
        String text = screen.getText();
        screen.setText(text + "-");
    }

    public void multiplicar(){
        String text = screen.getText();
        screen.setText(text + "*");
    }

    public void dividir(){
        String text = screen.getText();
        screen.setText(text + "/");
    }

    public void cero(){
        String text = screen.getText();
        screen.setText(text + "0");
    }

    public void uno(){
        String text = screen.getText();
        screen.setText(text + "1");
    }

    public void dos(){
        String text = screen.getText();
        screen.setText(text + "2");
    }

    public void tres(){
        String text = screen.getText();
        screen.setText(text + "3");
    }

    public void cuatro(){
        String text = screen.getText();
        screen.setText(text + "4");
    }

    public void cinco(){
        String text = screen.getText();
        screen.setText(text + "5");
    }

    public void seis(){
        String text = screen.getText();
        screen.setText(text + "6");
    }

    public void siete(){
        String text = screen.getText();
        screen.setText(text + "7");
    }

    public void ocho(){
        String text = screen.getText();
        screen.setText(text + "8");
    }

    public void nueve(){
        String text = screen.getText();
        screen.setText(text + "9");
    }



    public void igual() {
        String text = screen.getText();
        // Dividir el texto en tokens (números y operadores)
        String[] tokens = text.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");

        // Pilas para números y operadores
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                numbers.push(Integer.parseInt(token)); // Token a número y lo agrega a la pila
            } else if (isOperator(token)) {
                char operator = token.charAt(0); // Primer caracter
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(operator)) {
                    // Mientras haya operadores en la pila y el operador actual tenga menor o igual precedencia
                    performOperation(numbers, operators);
                    // Realiza la operación entre los dos últimos números de la pila y el último operador
                }
                // Agrega el operador a la pila
                operators.push(operator);
            }
        }

        while (!operators.isEmpty()) {
            performOperation(numbers, operators);
        }

        int result = numbers.pop();
        screen.setText(String.valueOf(result));
    }

    private boolean isNumber(String token) {
        return token.matches("\\d+"); // Verifica si el token es un número
    }

    private boolean isOperator(String token) {
        return token.matches("[+\\-*/]"); // Verifica si el token es un operador
    }

    private int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }

    private void performOperation(Stack<Integer> numbers, Stack<Character> operators) {
        // Realiza la operación entre los dos últimos números de la pila y el último operador
        int num2 = numbers.pop();
        int num1 = numbers.pop();
        char operator = operators.pop();
        int result = switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
        };

        numbers.push(result);
    }

}