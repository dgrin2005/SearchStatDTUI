package ru.geekbrains.internship;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ControllerAuth {

    private StartWindow mainApp;
    private RequestDB connDB;

    @FXML
    private TextField login;
    @FXML
    private TextField password;

    public void setMainApp(StartWindow mainApp) {
        this.mainApp = mainApp;
    }

    public void setDBApp(RequestDB connDB) {
        this.connDB = connDB;
    }

    public void pressOkButton() {
        if (connDB.checkAuthorization(login.getText(), password.getText())) {
            new DesktopUI(mainApp, connDB);
        }
    }

    public void pressCancelButton() {
        mainApp.paint(mainApp.getStage(), connDB);
    }

    public void pressRestorePasswordButton() {

    }

}
