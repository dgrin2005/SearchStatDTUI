package ru.geekbrains.internship.commands;

import javafx.scene.control.Alert;
import ru.geekbrains.internship.windows.AlertHandler;

public class RestorePasswordCommand implements Command {

    @Override
    public void execute() {
        new AlertHandler(Alert.AlertType.WARNING, "Предупреждение",
                "Внимание!", "Извините, операция на данный момент недоступна");
    }
}
