package ru.geekbrains.internship;

import javafx.scene.chart.LineChart;
import javafx.scene.control.*;

import java.time.LocalDate;

public class GetDailylStatisticsCommand implements Command {
    private StartWindow mainApp;
    private ChoiceBox<String> dailyStatisticsSite;
    private ChoiceBox<String> dailyStatisticsName;
    private DatePicker dailyStatisticsBeginDate;
    private DatePicker dailyStatisticsEndDate;
    private TableView<DailyStatistics> dailyStatisticsTable;
    private TextField dailyStatisticsTotalQuantity;
    private LineChart<String, Number> dailyStatisticsChart;

    public GetDailylStatisticsCommand(StartWindow mainApp, ChoiceBox<String> dailyStatisticsSite,
                                      ChoiceBox<String> dailyStatisticsName, DatePicker dailyStatisticsBeginDate,
                                      DatePicker dailyStatisticsEndDate, TableView<DailyStatistics> dailyStatisticsTable,
                                      TextField dailyStatisticsTotalQuantity, LineChart<String, Number> dailyStatisticsChart) {
        this.mainApp = mainApp;
        this.dailyStatisticsSite = dailyStatisticsSite;
        this.dailyStatisticsName = dailyStatisticsName;
        this.dailyStatisticsBeginDate = dailyStatisticsBeginDate;
        this.dailyStatisticsEndDate = dailyStatisticsEndDate;
        this.dailyStatisticsTable = dailyStatisticsTable;
        this.dailyStatisticsTotalQuantity = dailyStatisticsTotalQuantity;
        this.dailyStatisticsChart = dailyStatisticsChart;
    }

    @Override
    public void execute() {
        LocalDate beginDate = dailyStatisticsBeginDate.getValue();
        LocalDate endDate = dailyStatisticsEndDate.getValue();
        if (dailyStatisticsSite.getValue() != null) {
            if (dailyStatisticsName.getValue() != null) {
                if (beginDate != null) {
                    if (endDate != null) {
                        if (endDate.compareTo(beginDate) >= 0) {
                            dailyStatisticsTable.setItems(
                                    mainApp.getRequestDB().getDailyStatisticsList(mainApp.getDBStringURL(),
                                            dailyStatisticsSite.getValue(), dailyStatisticsName.getValue(),
                                            beginDate, endDate));
                            dailyStatisticsTotalQuantity.setText(Integer.toString(mainApp.getRequestDB().getDailyStatisticsTotal()));
                            dailyStatisticsChart.getData().add(mainApp.getRequestDB().getDailyStatisticsChartData(dailyStatisticsName.getValue()));
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
}
