package ru.geekbrains.internship.data;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TotalStatistics implements Statistics {
    private final StringProperty name;
    private final IntegerProperty quantity;

    public TotalStatistics(String name, int quantity) {
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }
}
