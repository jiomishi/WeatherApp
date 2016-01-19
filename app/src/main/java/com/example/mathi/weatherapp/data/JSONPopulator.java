package com.example.mathi.weatherapp.data;

/**
 * Created by mathi on 19/01/2016.
 */
import org.json.JSONException;
import org.json.JSONObject;

public interface JSONPopulator {
    void populate(JSONObject data) throws JSONException;

}