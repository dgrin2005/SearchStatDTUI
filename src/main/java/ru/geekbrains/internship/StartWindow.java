package ru.geekbrains.internship;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class StartWindow extends Application {

    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void start(Stage primaryStage){
        RequestDB requestDB = new RequestDB();
        setStage(primaryStage);
        paint(primaryStage, requestDB);

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void paint(Stage stage, RequestDB requestDB) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/startwin.fxml"));
            AnchorPane load = (AnchorPane) loader.load();
            ControllerStart controller = loader.getController();
            controller.setMainApp(this);
            controller.setDBApp(requestDB);
            Scene scene = new Scene(load);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("SearchStat");
            stage.show();
        } catch (IOException e) {
            new AlertHandler(Alert.AlertType.ERROR, "Ошибка", "Внимание!", "Ошибка ввода-вывода");
            //e.printStackTrace();
        }
    }

}
