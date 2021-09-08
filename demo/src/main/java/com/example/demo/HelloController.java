package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    private TextField inputField;

    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText(inputField.getText());
    }
}