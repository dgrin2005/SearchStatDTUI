package ru.geekbrains.internship.windows;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ru.geekbrains.internship.commands.Command;
import ru.geekbrains.internship.commands.ExitToMainMenuCommand;
import ru.geekbrains.internship.commands.PassAuthorizationCommand;
import ru.geekbrains.internship.commands.RestorePasswordCommand;
import ru.geekbrains.internship.windows.StartWindow;

public class ControllerAuth {

    private Command passAuthorizationCommand;
    private Command cancelAuthorizationCommand;
    private Command restorePasswordCommand;

    @FXML
    private TextField login;
    @FXML
    private TextField password;

    public void setMainApp(StartWindow mainApp) {
        passAuthorizationCommand = new PassAuthorizationCommand(mainApp, login, password);
        cancelAuthorizationCommand = new ExitToMainMenuCommand(mainApp);
        restorePasswordCommand = new RestorePasswordCommand();
    }

    public void pressOkButton() {
        passAuthorizationCommand.execute();
    }

    public void pressCancelButton() {
        cancelAuthorizationCommand.execute();
    }

    public void pressRestorePasswordButton() {
        restorePasswordCommand.execute();
    }

}
