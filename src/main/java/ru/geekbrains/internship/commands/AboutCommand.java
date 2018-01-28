package ru.geekbrains.internship.commands;

import javafx.scene.control.Alert;
import ru.geekbrains.internship.windows.AlertHandler;
import ru.geekbrains.internship.windows.StartWindow;

public class AboutCommand implements Command {

    private final StartWindow mainApp;

    public AboutCommand(StartWindow mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void execute() {
        new AlertHandler(Alert.AlertType.INFORMATION, "О программе", "SearchStat",
                '\u00A9' + " 2018 HardDevTeam");
    }
}
