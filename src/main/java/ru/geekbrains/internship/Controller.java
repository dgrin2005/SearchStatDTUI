package ru.geekbrains.internship;

import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ChoiceBox<String> totalStatisticsSite;

    @FXML
    private Button totalStatisticsUpdateButton;

    @FXML
    private TableView totalStatisticsTable;

    @FXML
    private ChoiceBox<String> dailyStatisticsSite;

    @FXML
    private ChoiceBox<String> dailyStatisticsName;

    @FXML
    private DatePicker dailyStatisticsBeginDate;

    @FXML
    private DatePicker dailyStatisticsEndDate;

    @FXML
    private Button dailyStatisticsUpdateButton;

    @FXML
    private TableView dailyStatisticsTable;

    @FXML
    private TextField dailyStatisticsTotalQuantity;


    public void dailyStatisticsUpdateButtonPressed() {
        // +++ проверка
        dailyStatisticsTotalQuantity.setText("Нажали кнопку 'Применить'");
        // --- проверка
    }

    public void dailyStatisticsBeginDateUpdate() {
        // проверка
        LocalDate date = dailyStatisticsBeginDate.getValue();
        dailyStatisticsTotalQuantity.setText("Selected date: " + date);
        // --- проверка
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // заполнение тестовых данных
        ObservableList<String> sites = FXCollections.observableArrayList(
                "lenta.ru","rbc.ru","rambler.ru");
        ObservableList<String> names = FXCollections.observableArrayList(
                "Путин","Медведев","Навальный");

        totalStatisticsSite.setItems(sites);
        dailyStatisticsSite.setItems(sites);
        dailyStatisticsName.setItems(names);
    }
}
