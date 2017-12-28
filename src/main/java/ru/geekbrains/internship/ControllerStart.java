package ru.geekbrains.internship;

public class ControllerStart {

    private StartWindow mainApp;

    public void setMainApp(StartWindow mainApp) {
        this.mainApp = mainApp;
    }

    public void pressStartButton() {
        mainApp.setConnDB(new ConnectionDB());
        mainApp.setRequestDB(new RequestDB());
        new AuthorizationWindow(mainApp);
    }

}
