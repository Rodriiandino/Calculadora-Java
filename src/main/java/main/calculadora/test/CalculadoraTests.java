package main.calculadora.test;
import main.calculadora.Calculadora;
public class CalculadoraTests {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        // Pruebas básicas
        Double result_1 = calculadora.performCalculation("1+1");
        System.out.println("1 + 1 = " + result_1);

        if (result_1 == 2) {
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 failed");
        }

        Double result_2 = calculadora.performCalculation("3-2");
        System.out.println("3 - 2 = " + result_2);

        if (result_2 == 1) {
            System.out.println("Test 2 passed");
        } else {
            System.out.println("Test 2 failed");
        }


        Double result_3 = calculadora.performCalculation("5*4");
        System.out.println("5 * 4 = " + result_3);

        if (result_3 == 20) {
            System.out.println("Test 3 passed");
        } else {
            System.out.println("Test 3 failed");
        }

        Double result_4 = calculadora.performCalculation("10/2");
        System.out.println("10 / 2 = " + result_4);

        if (result_4 == 5) {
            System.out.println("Test 4 passed");
        } else {
            System.out.println("Test 4 failed");
        }

        // Pruebas con números negativos
        Double result_5 = calculadora.performCalculation("-3+(-7)");
        System.out.println("-3 + (-7) = " + result_5);

        if (result_5 == -10) {
            System.out.println("Test 5 passed");
        } else {
            System.out.println("Test 5 failed");
        }

        Double result_6 = calculadora.performCalculation("-5*-2");
        System.out.println("-5 * (-2) = " + result_6);

        if (result_6 == 10) {
            System.out.println("Test 6 passed");
        } else {
            System.out.println("Test 6 failed");
        }

        // Prueba de módulo
        Double result_7 = calculadora.performCalculation("17%3");
        System.out.println("17 % 3 = " + result_7);

        if (result_7 == 2) {
            System.out.println("Test 7 passed");
        } else {
            System.out.println("Test 7 failed");
        }

        // Prueba de combinación de operaciones
        Double result_8 = calculadora.performCalculation("4+6*2");
        System.out.println("4 + 6 * 2 = " + result_8);

        if (result_8 == 16) {
            System.out.println("Test 8 passed");
        } else {
            System.out.println("Test 8 failed");
        }

        // Prueba con paréntesis
        Double result_9 = calculadora.performCalculation("(3+5)*2");
        System.out.println("(3 + 5) * 2 = " + result_9);

        if (result_9 == 16) {
            System.out.println("Test 9 passed");
        } else {
            System.out.println("Test 9 failed");
        }

        // Prueba con combinación de operaciones avanzadas
        Double result_10 = calculadora.performCalculation("9/3+12%5");
        System.out.println("9 / 3 + 12 % 5 = " + result_10);

        if (result_10 == 5) {
            System.out.println("Test 10 passed");
        } else {
            System.out.println("Test 10 failed");
        }


        // Prueba con numeros con .
        Double result_11 = calculadora.performCalculation("9.3+12%5");
        System.out.println("9.3 + 12 % 5 = " + result_11);

        if (result_11 == 11.3) {
            System.out.println("Test 11 passed");
        } else {
            System.out.println("Test 11 failed");
        }

        // Prueba con numeros con . y operaciones avanzadas
        Double result_12 = calculadora.performCalculation("1.3+3.3*9.5-6.5(4+5*3.3)");
        System.out.println("9.3 + 12 % 5 = " + result_12);

        if (result_12 == -100.6) {
            System.out.println("Test 12 passed");
        } else {
            System.out.println("Test 12 failed");
        }


    }
}
