package com.sample.controllers;

import com.sample.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class UserController {

    @FXML
    public Button secondaryButton;

    @FXML
    private void changeToMainView() throws IOException {
        App.changeView("mainview.fxml");
    }
}
