package ru.geekbrains.internship;

public class ControllerAuth {

    private StartWindow mainApp;
    private ConnectionDB connDB;

    public void setMainApp(StartWindow mainApp) {
        this.mainApp = mainApp;
    }

    public void setDBApp(ConnectionDB connDB) {
        this.connDB = connDB;
    }

    public void pressOkButton() {
        try {
            if (connDB.checkAuthorization()) {
                new DesktopUI(mainApp, connDB);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pressCancelButton() {
        try {
            System.exit(0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
