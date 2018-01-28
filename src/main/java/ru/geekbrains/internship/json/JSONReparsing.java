package ru.geekbrains.internship.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.collections.ObservableList;
import ru.geekbrains.internship.db.ConnectionDB;
import ru.geekbrains.internship.data.Statistics;

public abstract class JSONReparsing<T extends Statistics> {

    public void readJSON(String stringURL, ObservableList<T> tList) throws Exception {
        ConnectionDB connectionDB = new ConnectionDB(stringURL);
        String out = connectionDB.readDBResult();
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = (JsonArray) parser.parse(out);
        for (int j = 0; j < jsonArray.size(); j++) {
            JsonObject jsonObject = (JsonObject) jsonArray.get(j);
            tList.add(readJSONObject(jsonObject));
        }
        connectionDB.closeConnectionDB();
    }

    protected abstract T readJSONObject(JsonObject jsonObject);
}
