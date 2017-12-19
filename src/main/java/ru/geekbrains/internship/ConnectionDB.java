package ru.geekbrains.internship;

import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConnectionDB {

    private ObservableList<TotalStatistics> totalStatisticsList;
    private ObservableList<DailyStatistics> dailyStatisticsList;
    private ObservableList<String> sites;
    private ObservableList<String> names;

    public boolean checkAuthorization(String login, String password) {
        return true;
    }

    public ObservableList getTotalStatisticsList(String site) {
        totalStatisticsList = FXCollections.observableArrayList(
                new TotalStatistics("Путин",5000),
                new TotalStatistics("Медведев",4000),
                new TotalStatistics("Навальный",3000));
        return totalStatisticsList;
    }

    public ObservableList getDailyStatisticsList(String site, String name) {
        dailyStatisticsList = FXCollections.observableArrayList(
                new DailyStatistics("01-12-2017", 50),
                new DailyStatistics("02-12-2017",40),
                new DailyStatistics("03-12-2017",30));
        return dailyStatisticsList;
    }

    public int getDailyStatisticsTotal() {
        int totalPages = 0;
        for (DailyStatistics ds: dailyStatisticsList) {
            totalPages += ds.quantityProperty().getValue().intValue();
        }
        return totalPages;
    }

    public ObservableList getSites() {
        sites = FXCollections.observableArrayList(
                "lenta.ru","rbc.ru","rambler.ru");
        return sites;
    }
    public ObservableList getNames() {
        names = FXCollections.observableArrayList(
                "Путин","Медведев","Навальный");
        return names;
    }

}
