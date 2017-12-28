package ru.geekbrains.internship;

import javafx.fxml.*;
import javafx.geometry.Side;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControllerUI implements Initializable {

    private StartWindow mainApp;
    private RequestDB requestDB;

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
    @FXML
    private PieChart totalStatisticsChart;
    @FXML
    private LineChart<String, Number> dailyStatisticsChart;

    public void setMainApp(StartWindow mainApp) {
        this.mainApp = mainApp;
    }

    public void setDBApp(RequestDB connDB) {
        this.requestDB = connDB;
    }

    public void pressTotalStatisticsUpdateButton() {
        if (totalStatisticsSite.getValue() != null) {
            totalStatisticsTable.setItems(requestDB.getTotalStatisticsList(totalStatisticsSite.getValue()));
            totalStatisticsChart.setData(requestDB.getTotalStatisticsChartData());
            totalStatisticsChart.setLabelLineLength(10);
            totalStatisticsChart.setLegendSide(Side.LEFT);
        } else {
            new AlertHandler(Alert.AlertType.WARNING, "Не заполнен параметр",
                    "Внимание!", "Необходимо выбрать сайт");
        }
    }

    public void pressDailyStatisticsUpdateButton() {
        LocalDate beginDate = dailyStatisticsBeginDate.getValue();
        LocalDate endDate = dailyStatisticsEndDate.getValue();
        if (dailyStatisticsSite.getValue() != null) {
            if (dailyStatisticsName.getValue() != null) {
                if (beginDate != null) {
                    if (endDate != null) {
                        if (endDate.compareTo(beginDate) >= 0) {
                            dailyStatisticsTable.setItems(
                                    requestDB.getDailyStatisticsList(
                                            dailyStatisticsSite.getValue(), dailyStatisticsName.getValue(),
                                            beginDate, endDate));
                            dailyStatisticsTotalQuantity.setText(Integer.toString(requestDB.getDailyStatisticsTotal()));
                            dailyStatisticsChart.getData().add(requestDB.getDailyStatisticsChartData(dailyStatisticsName.getValue()));
                            dailyStatisticsChart.setTitle("");
                        } else {
                            new AlertHandler(Alert.AlertType.WARNING, "Не верно заполнены параметры",
                                    "Внимание!", "Начальная дата должна быть раньше конечной");
                        }
                    } else {
                        new AlertHandler(Alert.AlertType.WARNING, "Не заполнен параметр",
                                "Внимание!", "Необходимо выбрать конечную дату");
                    }
                } else {
                    new AlertHandler(Alert.AlertType.WARNING, "Не заполнен параметр",
                            "Внимание!", "Необходимо выбрать начальную дату");
                }
            } else {
                new AlertHandler(Alert.AlertType.WARNING, "Не заполнен параметр",
                        "Внимание!", "Необходимо выбрать имя");
            }
        } else {
            new AlertHandler(Alert.AlertType.WARNING, "Не заполнен параметр",
                    "Внимание!", "Необходимо выбрать сайт");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tstColumnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tstColumnQuantity.setCellValueFactory(cellData -> cellData.getValue().quantityProperty());
        dstColumnDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        dstColumnQuantity.setCellValueFactory(cellData -> cellData.getValue().quantityProperty());
    }

    public void fillLists() {
        totalStatisticsSite.setItems(requestDB.getSites());
        dailyStatisticsSite.setItems(requestDB.getSites());
        dailyStatisticsName.setItems(requestDB.getNames());
    }

}
