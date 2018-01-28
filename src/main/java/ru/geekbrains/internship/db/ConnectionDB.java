package ru.geekbrains.internship.db;

import javafx.scene.control.Alert;
import ru.geekbrains.internship.windows.AlertHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionDB {

    private HttpURLConnection dBCon;

    public ConnectionDB(String DBStringURL) throws Exception {
        URL dBUrl = new URL(DBStringURL);
        dBCon = (HttpURLConnection) dBUrl.openConnection();
    }

    public String readDBResult() {
        StringBuilder out = new StringBuilder();
        BufferedReader in = null;
        String inputLine;
        try {
            in = new BufferedReader(new InputStreamReader(dBCon.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            new AlertHandler(Alert.AlertType.ERROR,
                    "Ошибка", "Внимание!", "Ошибка чтения данных из БД");
            return "";
        }
        try {
            while ((inputLine = in.readLine()) != null) {
                out.append(inputLine);
            }
        } catch (IOException e) {
            new AlertHandler(Alert.AlertType.ERROR,
                    "Ошибка", "Внимание!", "Ошибка ввода-вывода");
            return "";
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                new AlertHandler(Alert.AlertType.ERROR,
                        "Ошибка", "Внимание!", "Ошибка ввода-вывода");
            }
        }
        return out.toString();
    }

    public void closeConnectionDB() {
        dBCon.disconnect();
    }

}
