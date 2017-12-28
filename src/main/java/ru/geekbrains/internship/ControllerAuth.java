package ru.geekbrains.internship;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ControllerAuth {

    private StartWindow mainApp;
    private RequestDB requestDB;

    @FXML
    private TextField login;
    @FXML
    private TextField password;

    public void setMainApp(StartWindow mainApp) {
        this.mainApp = mainApp;
    }

    public void setDBApp(RequestDB requestDB) {
        this.requestDB = requestDB;
    }

    public void pressOkButton() {
        if (requestDB.checkAuthorization(login.getText(), password.getText())) {
            new DesktopUI(mainApp, requestDB);
        }
    }

    public void pressCancelButton() {
        mainApp.paint(mainApp.getStage(), requestDB);
    }

    public void pressRestorePasswordButton() {

    }

}
