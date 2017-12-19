package ru.geekbrains.internship;

import javafx.fxml.*;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerUI implements Initializable {

    private StartWindow mainApp;
    private ConnectionDB connDB;

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

    public void setMainApp(StartWindow mainApp) {
        this.mainApp = mainApp;
    }

    public void setDBApp(ConnectionDB connDB) {
        this.connDB = connDB;
    }

    public void pressTotalStatisticsUpdateButton() {
        totalStatisticsTable.setItems(connDB.getTotalStatisticsList());
    }

    public void pressDailyStatisticsUpdateButton() {
        dailyStatisticsTable.setItems(connDB.getDailyStatisticsList());
    }

    public void updateDailyStatisticsBeginDate() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tstColumnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tstColumnQuantity.setCellValueFactory(cellData -> cellData.getValue().quantityProperty());
        dstColumnDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        dstColumnQuantity.setCellValueFactory(cellData -> cellData.getValue().quantityProperty());
    }

    public void fillLists() {
        totalStatisticsSite.setItems(connDB.getSites());
        dailyStatisticsSite.setItems(connDB.getSites());
        dailyStatisticsName.setItems(connDB.getNames());
    }

}
