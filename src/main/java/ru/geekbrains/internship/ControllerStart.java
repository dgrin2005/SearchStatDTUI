package ru.geekbrains.internship;

public class ControllerStart {

    private StartWindow mainApp;
    private ConnectionDB connDB;

    public void setMainApp(StartWindow mainApp) {
        this.mainApp = mainApp;
    }

    public void setDBApp(ConnectionDB connDB) {
        this.connDB = connDB;
    }

    public void pressStartButton() {
        try {
            new AuthorizationWindow(mainApp, connDB);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
