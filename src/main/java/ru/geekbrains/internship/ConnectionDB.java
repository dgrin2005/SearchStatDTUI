package ru.geekbrains.internship;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConnectionDB {

    public boolean checkAuthorization() {
        return true;
    }

    public ObservableList getTotalStatisticsList(String site) {
        ObservableList<TotalStatistics> totalStatisticsList = FXCollections.observableArrayList(
                new TotalStatistics("Путин",5000),
                new TotalStatistics("Медведев",4000),
                new TotalStatistics("Навальный",3000));
        return totalStatisticsList;
    }

    public ObservableList getDailyStatisticsList(String site, String name) {
        ObservableList<DailyStatistics> dailyStatisticsList = FXCollections.observableArrayList(
                new DailyStatistics("01-12-2017", 50),
                new DailyStatistics("02-12-2017",40),
                new DailyStatistics("03-12-2017",30));
        return dailyStatisticsList;
    }

    public ObservableList getSites() {
        ObservableList<String> sites = FXCollections.observableArrayList(
                "lenta.ru","rbc.ru","rambler.ru");
        return sites;
    }
    public ObservableList getNames() {
        ObservableList<String> names = FXCollections.observableArrayList(
                "Путин","Медведев","Навальный");
        return names;
    }

}
