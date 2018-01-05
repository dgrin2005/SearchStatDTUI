package ru.geekbrains.internship;

import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;

public class GetTotalStatisticsCommand implements Command {
    private StartWindow mainApp;
    private ChoiceBox<String> totalStatisticsSite;
    private TableView<TotalStatistics> totalStatisticsTable;
    private PieChart totalStatisticsChart;

    public GetTotalStatisticsCommand(StartWindow mainApp, ChoiceBox<String> totalStatisticsSite, TableView<TotalStatistics> totalStatisticsTable, PieChart totalStatisticsChart) {
        this.mainApp = mainApp;
        this.totalStatisticsSite = totalStatisticsSite;
        this.totalStatisticsTable = totalStatisticsTable;
        this.totalStatisticsChart = totalStatisticsChart;
    }

    @Override
    public void execute() {
        if (totalStatisticsSite.getValue() != null) {
            totalStatisticsTable.setItems(mainApp.getRequestDB().getTotalStatisticsList(mainApp.getDBStringURL(),
                    totalStatisticsSite.getValue()));
            totalStatisticsChart.setData(mainApp.getRequestDB().getTotalStatisticsChartData());
            totalStatisticsChart.setLabelLineLength(10);
            totalStatisticsChart.setLegendSide(Side.LEFT);
        } else {
            new AlertHandler(Alert.AlertType.WARNING, "Не заполнен параметр",
                    "Внимание!", "Необходимо выбрать сайт");
        }
    }
}
