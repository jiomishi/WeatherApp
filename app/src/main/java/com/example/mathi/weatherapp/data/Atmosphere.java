package com.example.mathi.weatherapp.data;

import org.json.JSONObject;

/**
 * Created by mathi on 19/01/2016.
 */


public class Atmosphere implements  JSONPopulator {
    private int humidity;
    private int visibility;



    public int getHumidity(){return humidity;}

    public int getVisibility(){return visibility;}

    @Override
    public void populate(JSONObject data) {

        humidity=data.optInt("humidity");
        visibility=data.optInt("visibility");
    }
}
