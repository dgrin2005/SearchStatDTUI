package ru.geekbrains.internship;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class ConnectionDB {

    private ObservableList<TotalStatistics> totalStatisticsList;
    private ObservableList<DailyStatistics> dailyStatisticsList;
    private ObservableList<String> sites;
    private ObservableList<String> names;

    public boolean checkAuthorization(String login, String password) throws Exception {
        return true;
    }

    public ObservableList getTotalStatisticsList(String site) throws Exception {
        totalStatisticsList = FXCollections.observableArrayList(
                new TotalStatistics("Путин",5000),
                new TotalStatistics("Медведев",4000),
                new TotalStatistics("Навальный",3000));
        return totalStatisticsList;
    }

    public ObservableList getDailyStatisticsList(String site, String name, LocalDate beginDate, LocalDate endDate) throws Exception {
        dailyStatisticsList = FXCollections.observableArrayList(
                new DailyStatistics("01-12-2017", 50),
                new DailyStatistics("02-12-2017",40),
                new DailyStatistics("03-12-2017",30));
        return dailyStatisticsList;
    }

    public int getDailyStatisticsTotal() throws Exception {
        int totalPages = 0;
        for (DailyStatistics ds: dailyStatisticsList) {
            totalPages += ds.quantityProperty().getValue().intValue();
        }
        return totalPages;
    }

    public ObservableList getSites() throws Exception {
        sites = FXCollections.observableArrayList(
                "lenta.ru","rbc.ru","rambler.ru");
        return sites;
    }
    public ObservableList getNames() throws Exception {
        names = FXCollections.observableArrayList(
                "Путин","Медведев","Навальный");
        return names;
    }

}
