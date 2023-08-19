package main.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculadoraController {

    @FXML
    private Label screen;

    private final Calculadora calculadora = new Calculadora();


    private void newOperatorAndPoint(ActionEvent event) {
        String text = screen.getText();
        Button sourceButton = (Button) event.getSource();
        String operador = sourceButton.getText();

        if (text.isEmpty() && operador.equals("-")) {
            screen.setText(operador);
            return;
        }

        if (text.isEmpty()) {
            return;
        }

        if (text.substring(text.length() - 1).matches("[+\\-*/%.]") ) {
            text = text.substring(0, text.length() - 1);
        }

        screen.setText(text + operador);
    }


    public void newOperator(ActionEvent event) {
        newOperatorAndPoint(event);
    }


    public void newNumber(ActionEvent event) {
        String text = screen.getText();
        if (text.equals("0")) text = "";
        Button sourceButton = (Button) event.getSource();
        String number = sourceButton.getText();

        screen.setText(text + number);
    }

    public void newPoint(ActionEvent event) {
        newOperatorAndPoint(event);
    }

    public void newParenthesis(ActionEvent event) {
        String text = screen.getText();
        Button sourceButton = (Button) event.getSource();
        String parenthesis = sourceButton.getText();

        if (parenthesis.equals(")") && countOccurrences(text, "(") <= countOccurrences(text, ")")) {
            return;
        }

        if (text.equals("0")) {
            text = "";
        }

        screen.setText(text + parenthesis);
    }

    private int countOccurrences(String text, String target) {
        int count = 0;
        int index = text.indexOf(target);
        while (index != -1) {
            count++;
            index = text.indexOf(target, index + 1);
        }
        return count;
    }

    public void equal() {
        String text = screen.getText();
        if (!text.isEmpty()) {
            double result = calculadora.performCalculation(text);
            screen.setText(String.valueOf(result));
            if (result % 1 == 0) {
                int intResult = (int) result;
                screen.setText(String.valueOf(intResult));
            } else {
                screen.setText(String.valueOf(result));
            }
        }
    }

    public void eraseLast() {
        String text = screen.getText();
        if (!text.isEmpty()) {
            screen.setText(text.substring(0, text.length() - 1));
        }
    }

    public void eraseAll() {
        String text = screen.getText();
        if (!text.isEmpty()) {
            screen.setText("");
        }
    }
}


