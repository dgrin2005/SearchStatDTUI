package ru.geekbrains.internship;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchStatDTUI extends Application {

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        try {

            ConnectionDB connDB = new ConnectionDB();
            setStage(primaryStage);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/startwin.fxml"));
            AnchorPane load = (AnchorPane) loader.load();
            ControllerStart controller = loader.getController();
            controller.setMainApp(this);
            controller.setDBApp(connDB);

            Scene scene = new Scene(load);
            primaryStage.setScene(scene);
            primaryStage.setTitle("SearchStat");
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
