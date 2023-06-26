package main.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculadoraController {

    @FXML
    private Label screen;

    private final Calculadora calculadora = new Calculadora();


    public void newOperator(ActionEvent event) {
        String text = screen.getText();
        if (text.substring(text.length() - 1).matches("[+\\-*/%]")) {
            text = text.substring(0, text.length() - 1);
        }
        Button sourceButton = (Button) event.getSource();
        String operador = sourceButton.getText();
        screen.setText(text + operador);
    }

    public void newNumber(ActionEvent event) {
        String text = screen.getText();
        if (text.equals("0")) {
            text = "";
        }
        Button sourceButton = (Button) event.getSource();
        String number = sourceButton.getText();

        screen.setText(text + number);
    }

    public void newPoint(ActionEvent event) {
        String text = screen.getText();
        if (text.equals("0")) {
            text = "";
        }
        Button sourceButton = (Button) event.getSource();
        String point = sourceButton.getText();

        screen.setText(text + point);
    }

    public void newParenthesis(ActionEvent event) {
        String text = screen.getText();
        if (text.equals("0")) {
            text = "";
        }
        Button sourceButton = (Button) event.getSource();
        String parenthesis = sourceButton.getText();

        screen.setText(text + parenthesis);
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


