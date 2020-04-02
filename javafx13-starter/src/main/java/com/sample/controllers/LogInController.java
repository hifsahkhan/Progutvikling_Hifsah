package com.sample.controllers;

import java.io.IOException;

import com.sample.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LogInController {

    @FXML
    private Button mainButton;
    @FXML
    private Button thirdButton;

    @FXML
    private void changeToSecondaryView() throws IOException {
        App.changeView("superUserView.fxml");
    }


    @FXML
    private void changeToThirdView() throws IOException {
        App.changeView("thirdview.fxml");
    }
}
