package ru.geekbrains.internship.windows;

import ru.geekbrains.internship.commands.Command;
import ru.geekbrains.internship.commands.ExitToOSCommand;
import ru.geekbrains.internship.commands.SettingsCommand;
import ru.geekbrains.internship.commands.StartApplicationCommand;
import ru.geekbrains.internship.windows.StartWindow;

public class ControllerStart {

    private Command startApplicationCommand;
    private Command settingsCommand;
    private Command exitToOSCommand;

    public void setMainApp(StartWindow mainApp) {
        startApplicationCommand = new StartApplicationCommand(mainApp);
        settingsCommand = new SettingsCommand(mainApp);
        exitToOSCommand = new ExitToOSCommand(mainApp);
    }

    public void pressStartButton() {
        startApplicationCommand.execute();
    }

    public void pressSettingsButton() {
        settingsCommand.execute();
    }

    public void pressExitButton() {
        exitToOSCommand.execute();
    }
}
