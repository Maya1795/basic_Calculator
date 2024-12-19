package com.example.demo2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Calculator calculator = new Calculator();
        CalculatorController controller = new CalculatorController(calculator);

        Scene scene = new Scene(controller.getView(), 300, 400);
        stage.setTitle("Basic OOP Calculator"); // Use 'stage' instead of 'primaryStage'
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
