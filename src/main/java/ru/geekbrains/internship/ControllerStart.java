package ru.geekbrains.internship;

public class ControllerStart {

    private StartWindow mainApp;
    private Command startApplicationCommand;
    private Command settingsCommand;

    public void setMainApp(StartWindow mainApp) {
        this.mainApp = mainApp;
        startApplicationCommand = new StartApplicationCommand(this.mainApp);
        settingsCommand = new SettingsCommand(this.mainApp);
    }

    public void pressStartButton() {
        startApplicationCommand.execute();
    }

    public void pressSettingsButton() {
        settingsCommand.execute();
    }
}
