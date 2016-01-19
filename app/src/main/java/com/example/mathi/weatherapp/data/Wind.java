package com.example.mathi.weatherapp.data;

import org.json.JSONObject;

/**
 * Created by mathi on 18/01/2016.
 */
public class Wind implements  JSONPopulator {
    private int speed;



    public int getSpeed(){return speed;}

    @Override
    public void populate(JSONObject data) {


        speed=data.optInt("speed");
    }
}