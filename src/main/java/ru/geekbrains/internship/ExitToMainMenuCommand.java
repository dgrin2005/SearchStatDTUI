package ru.geekbrains.internship;

public class ExitToMenuCommand implements Command {

    private final StartWindow mainApp;

    ExitToMenuCommand(StartWindow mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void execute() {
        mainApp.paint(mainApp.getStage());
    }
}
