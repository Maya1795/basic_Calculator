package com.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class CalculatorController {
    private final Calculator calculator;

    @FXML
    private TextField display;

    // Constructor that initializes the calculator
    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    // The method should be public and annotated with @FXML to link it to the FXML file
    @FXML
    private void handleButtonClick(javafx.event.ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        String value = sourceButton.getText();

        if ("C".equals(value)) {
            display.clear();
            calculator.clear();
        } else if ("=".equals(value)) {
            try {
                double result = calculator.eval(display.getText());
                display.setText(String.valueOf(result));
            } catch (Exception e) {
                display.setText("Error");
            }
        } else if ("Undo".equals(value)) {
            String currentText = display.getText();
            if (currentText.length() > 0) {
                // Remove the last character (undo last input)
                display.setText(currentText.substring(0, currentText.length() - 1));
            }
        } else {
            display.appendText(value); // Append button value to the display
        }
    }

    // Method to return the view (GridPane layout)
    public GridPane getView() {
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);

        // Add the display at the top
        display = new TextField();
        display.setEditable(false);
        display.setStyle("-fx-font-size: 20; -fx-text-alignment: right; -fx-text-fill: green; -fx-pref-width: 320;");
        grid.add(display, 0, 0, 4, 1);

        
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "(", ")", "C", "Undo"
        };

        int row = 1, col = 0;
        for (String text : buttons) {
            Button button = new Button(text);
            button.setStyle("-fx-font-size: 18; -fx-pref-width: 80; -fx-pref-height: 100; " +
                    "-fx-background-color: white; -fx-text-fill: green;");
            button.setOnAction(e -> handleButtonClick(e));
            grid.add(button, col, row);
            col++;
            if (col > 3) {
                col = 0;
                row++;
            }
        }

        return grid;
    }
}
