package ru.geekbrains.internship.commands;

import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import ru.geekbrains.internship.windows.StartWindow;
import ru.geekbrains.internship.data.TotalStatistics;

public class GetTotalStatisticsCommand implements Command {
    private final StartWindow mainApp;
    private final ChoiceBox<String> totalStatisticsSite;
    private final TableView<TotalStatistics> totalStatisticsTable;
    private final PieChart totalStatisticsChart;

    public GetTotalStatisticsCommand(StartWindow mainApp, ChoiceBox<String> totalStatisticsSite,
                                     TableView<TotalStatistics> totalStatisticsTable, PieChart totalStatisticsChart) {
        this.mainApp = mainApp;
        this.totalStatisticsSite = totalStatisticsSite;
        this.totalStatisticsTable = totalStatisticsTable;
        this.totalStatisticsChart = totalStatisticsChart;
    }

    @Override
    public void execute() {
        if (totalStatisticsSite.getValue() != null) {
            totalStatisticsTable.setItems(mainApp.getRequestDB().getTotalStatisticsList(mainApp.getDBStringURL(),
                    totalStatisticsSite.getValue(), mainApp.getToken()));
            totalStatisticsChart.setData(mainApp.getRequestDB().getTotalStatisticsChartData());
            totalStatisticsChart.setLabelLineLength(10);
            totalStatisticsChart.setLegendSide(Side.LEFT);
        }
    }
}
