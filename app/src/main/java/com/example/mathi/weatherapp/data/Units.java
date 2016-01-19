package com.example.mathi.weatherapp.data;

import org.json.JSONObject;

public class Units implements JSONPopulator {
    private String temperature;
    private String speed;
    private String distance;

    public String getTemperature() {
        return temperature;
    }

    public String getSpeed(){return speed;}

    public String getDistance(){return distance;}

    @Override
    public void populate(JSONObject data) {

        temperature = data.optString("temperature");
        speed=data.optString("speed");
        distance=data.optString("distance");
    }

}