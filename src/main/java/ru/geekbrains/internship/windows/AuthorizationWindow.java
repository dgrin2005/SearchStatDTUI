package ru.geekbrains.internship.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthorizationWindow {

    public AuthorizationWindow(StartWindow mainApp) throws IOException {
        FXMLLoader loader = new FXMLLoader(mainApp.getClass().getResource("/authwin.fxml"));
        AnchorPane load = loader.load();
        ControllerAuth controller = loader.getController();
        controller.setMainApp(mainApp);
        Stage stage = mainApp.getStage();
        stage.setTitle("Authorization");
        Scene scene = new Scene(load);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
