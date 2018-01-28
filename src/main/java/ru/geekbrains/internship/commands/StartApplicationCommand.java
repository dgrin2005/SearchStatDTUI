package ru.geekbrains.internship.commands;

import javafx.scene.control.Alert;
import ru.geekbrains.internship.windows.AlertHandler;
import ru.geekbrains.internship.windows.AuthorizationWindow;
import ru.geekbrains.internship.db.RequestDB;
import ru.geekbrains.internship.windows.StartWindow;

import java.io.IOException;

public class StartApplicationCommand implements Command {

    private final StartWindow mainApp;

    public StartApplicationCommand(StartWindow mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void execute() {

        try {
            mainApp.setRequestDB(new RequestDB());
            new AuthorizationWindow(mainApp);
        } catch (IOException e ) {
            new AlertHandler(Alert.AlertType.ERROR,
                    "Ошибка", "Внимание!", "Ошибка ввода-вывода");
        } catch (Exception e) {
            new AlertHandler(Alert.AlertType.ERROR,
                    "Ошибка", "Внимание!", "Ошибка подключения к БД");
        }
    }
}
