package ru.geekbrains.internship;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SearchStatDTUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/searchstat.fxml"));
        primaryStage.setTitle("SearchStat");
        primaryStage.setScene(new Scene(root, 460, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
