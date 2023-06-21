module main.calculadora {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens main.calculadora to javafx.fxml;
    exports main.calculadora;
}