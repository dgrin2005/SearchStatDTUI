package ru.geekbrains.internship.json;

import com.google.gson.JsonObject;
import ru.geekbrains.internship.data.StringList;

public class ListJSONReparsing extends JSONReparsing<StringList> {

    @Override
    public StringList readJSONObject(JsonObject jsonObject) {
        String stringID = jsonObject.get("id").getAsString();
        String stringName = jsonObject.get("name").getAsString();
        return new StringList(stringID, stringName);
    }
}
