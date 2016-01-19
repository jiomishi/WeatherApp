package com.example.mathi.weatherapp.data;

/**
 * Created by mathi on 19/01/2016.
 */

import org.json.JSONException;
import org.json.JSONObject;

public class Channel implements JSONPopulator {
    private Units units;
    private Item item;
    private Wind wind;
    private Atmosphere atmosphere;

    public Units getUnits() {
        return units;
    }
    public Item getItem() {
        return item;
    }
    public Wind getWind(){ return wind;}
    public Atmosphere getAtmosphere(){return atmosphere;}




    @Override
    public void populate(JSONObject data) throws JSONException {

        units = new Units();
        units.populate(data.optJSONObject("units"));

        item = new Item();
        item.populate(data.optJSONObject("item"));

        wind=new Wind();
        wind.populate(data.optJSONObject("wind"));

        atmosphere=new Atmosphere();
        atmosphere.populate(data.optJSONObject("atmosphere"));



    }
}
