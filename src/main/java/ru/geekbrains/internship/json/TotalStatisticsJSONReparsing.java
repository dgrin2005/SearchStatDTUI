package ru.geekbrains.internship.json;

import com.google.gson.JsonObject;
import ru.geekbrains.internship.data.TotalStatistics;

public class TotalStatisticsJSONReparsing extends JSONReparsing<TotalStatistics> {

    @Override
    public TotalStatistics readJSONObject(JsonObject jsonObject) {
        String stringPersonName = jsonObject.get("name").getAsString();
        String stringPersonRank = jsonObject.get("rank").getAsString();
        return new TotalStatistics(stringPersonName, Integer.parseInt(stringPersonRank));
    }
}
