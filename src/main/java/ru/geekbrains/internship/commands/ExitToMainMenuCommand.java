package ru.geekbrains.internship.commands;

import javafx.scene.control.Alert;
import ru.geekbrains.internship.windows.AlertHandler;
import ru.geekbrains.internship.windows.StartWindow;

import java.io.IOException;

public class ExitToMainMenuCommand implements Command {

    private final StartWindow mainApp;

    public ExitToMainMenuCommand(StartWindow mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void execute() {
        try {
            mainApp.paint(mainApp.getStage());
        } catch (IOException e) {
            new AlertHandler(Alert.AlertType.ERROR,
                    "Ошибка", "Внимание!", "Ошибка ввода-вывода");
        }
    }
}
