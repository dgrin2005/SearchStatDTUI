package ru.geekbrains.internship;

import javafx.scene.control.TextField;

public class PassAuthorizationCommand implements Command {

    private StartWindow mainApp;
    private TextField login;
    private TextField password;

    public PassAuthorizationCommand(StartWindow mainApp, TextField login, TextField password) {
        this.mainApp = mainApp;
        this.login = login;
        this.password = password;
    }

    @Override
    public void execute() {
        if (mainApp.getRequestDB().checkAuthorization(login.getText(), password.getText())) {
            new DesktopUI(mainApp);
        }
    }
}
