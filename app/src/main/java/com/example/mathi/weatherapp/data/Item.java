package com.example.mathi.weatherapp.data;

import org.json.JSONException;
import org.json.JSONObject;

public class Item implements JSONPopulator {
    private Condition condition;
    private Forecast forecast;


    public Condition getCondition() {
        return condition;
    }

    public Forecast getForecast(){return forecast;}



    @Override
    public void populate(JSONObject data) throws JSONException {
        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));

        forecast = new Forecast();
        forecast.populate(data.getJSONArray("forecast"));

    }
}