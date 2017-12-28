package ru.geekbrains.internship;

public class ControllerStart {

    private StartWindow mainApp;
    private RequestDB requestDB;

    public void setMainApp(StartWindow mainApp) {
        this.mainApp = mainApp;
    }

    public void setDBApp(RequestDB connDB) {
        this.requestDB = connDB;
    }

    public void pressStartButton() {
        new AuthorizationWindow(mainApp, requestDB);
    }

}
