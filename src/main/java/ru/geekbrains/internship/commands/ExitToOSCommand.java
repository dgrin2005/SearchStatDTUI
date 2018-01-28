package ru.geekbrains.internship.commands;

import ru.geekbrains.internship.windows.StartWindow;

public class ExitToOSCommand implements Command {

    private final StartWindow mainApp;

    public ExitToOSCommand(StartWindow mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
