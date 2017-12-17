package ru.geekbrains.internship;

import java.time.LocalDate;

public class DailyStatistics {
    private LocalDate date;
    private int quantity;

    public DailyStatistics(LocalDate date, int quantity) {
        this.date = date;
        this.quantity = quantity;
    }
}
