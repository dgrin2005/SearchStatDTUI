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
    private TableView<TotalStatistics> totalStatisticsTable;

    @FXML
    private TableColumn<TotalStatistics, String> tstColumnName;

    @FXML
    private TableColumn<TotalStatistics, Number> tstColumnQuantity;

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
    private TableView<DailyStatistics> dailyStatisticsTable;

    @FXML
    private TableColumn<DailyStatistics, String> dstColumnDate;

    @FXML
    private TableColumn<DailyStatistics, Number> dstColumnQuantity;

    @FXML
    private TextField dailyStatisticsTotalQuantity;


    public void pressTotalStatisticsUpdateButton() {
        // +++ заполнение тестовых данных
        ObservableList<TotalStatistics> totalStatisticsList = FXCollections.observableArrayList(
                new TotalStatistics("Путин",5000),
                new TotalStatistics("Медведев",4000),
                new TotalStatistics("Навальный",3000));
        totalStatisticsTable.setItems(totalStatisticsList);
        // --- заполнение тестовых данных
    }

    public void pressDailyStatisticsUpdateButton() {
        // +++ заполнение тестовых данных
        ObservableList<DailyStatistics> dailyStatisticsList = FXCollections.observableArrayList(
                new DailyStatistics("01-12-2017", 50),
                new DailyStatistics("02-12-2017",40),
                new DailyStatistics("03-12-2017",30));
        dailyStatisticsTable.setItems(dailyStatisticsList);
        // --- заполнение тестовых данных
    }

    public void updateDailyStatisticsBeginDate() {
        // +++ проверка
        LocalDate date = dailyStatisticsBeginDate.getValue();
        dailyStatisticsTotalQuantity.setText("Selected date: " + date);
        // --- проверка
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tstColumnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tstColumnQuantity.setCellValueFactory(cellData -> cellData.getValue().quantityProperty());

        dstColumnDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        dstColumnQuantity.setCellValueFactory(cellData -> cellData.getValue().quantityProperty());

        // +++ заполнение тестовых данных
        ObservableList<String> sites = FXCollections.observableArrayList(
                "lenta.ru","rbc.ru","rambler.ru");
        ObservableList<String> names = FXCollections.observableArrayList(
                "Путин","Медведев","Навальный");

        totalStatisticsSite.setItems(sites);
        dailyStatisticsSite.setItems(sites);
        dailyStatisticsName.setItems(names);
        // --- заполнение тестовых данных


    }
}
