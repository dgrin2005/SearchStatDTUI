package ru.geekbrains.internship;

import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionDB implements ConnectionDBConst {

    private HttpURLConnection dBCon;

    public ConnectionDB() {
        try {
            URL dBUrl = new URL(DBSTRINGURL);
            dBCon = (HttpURLConnection) dBUrl.openConnection();
        } catch (Exception e) {
            new AlertHandler(Alert.AlertType.ERROR, "Ошибка", "Внимание!", "Ошибка подключения к БД");
            //e.printStackTrace();
        }
    }

    public String readDBResult() {
        String out = "";
        try {
            InputStream is = dBCon.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while(br.ready()) {
                out += br.readLine();
            }
            br.close();
            is.close();
        } catch (IOException e) {
            new AlertHandler(Alert.AlertType.ERROR, "Ошибка", "Внимание!", "Ошибка чтения данных из БД");
            //e.printStackTrace();
        }
        return out;
    }

    public void closeConnectionDB() {
        dBCon.disconnect();
    }

}
