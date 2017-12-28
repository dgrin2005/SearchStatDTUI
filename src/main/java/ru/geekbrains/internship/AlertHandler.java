package ru.geekbrains.internship;

import javafx.scene.control.Alert;

public class AlertHandler {

    private Alert.AlertType alertType;
    private String title;
    private String header;
    private String content;

    public AlertHandler(Alert.AlertType alertType, String title, String header, String content) {
        this.alertType = alertType;
        this.title = title;
        this.header = header;
        this.content = content;

        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }
}
