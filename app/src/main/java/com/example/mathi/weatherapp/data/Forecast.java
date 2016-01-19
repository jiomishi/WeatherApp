package com.example.mathi.weatherapp.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mathi on 19/01/2016.
 */
public class Forecast {

    private String day1;
    private int high1;
    private int low1;
    private String text1;

    private String day2;
    private int high2;
    private int low2;
    private String text2;

    private String day3;
    private int high3;
    private int low3;
    private String text3;

    private String day4;
    private int high4;
    private int low4;
    private String text4;

    private String day5;
    private int high5;
    private int low5;
    private String text5;

    public String getDay1(){return day1;}
    public int getHigh1() {return high1;}
    public int getLow1() {return low1;}
    public String getText1() {return text1;}

    public String getDay2(){return day2;}
    public int getHigh2() {return high2;}
    public int getLow2() {return low2;}
    public String getText2() {return text2;}

    public String getDay3(){return day3;}
    public int getHigh3() {return high3;}
    public int getLow3() {return low3;}
    public String getText3() {return text3;}

    public String getDay4(){return day4;}
    public int getHigh4() {return high4;}
    public int getLow4() {return low4;}
    public String getText4() {return text4;}

    public String getDay5(){return day5;}
    public int getHigh5() {  return high5;}
    public int getLow5() {   return low5;}
    public String getText5() {    return text5;}


    public void populate(JSONArray data) throws JSONException{
        day1 = data.getJSONObject(0).optString("day");
        high1 = data.getJSONObject(0).optInt("high");
        low1 = data.getJSONObject(0).optInt("low");
        text1=data.getJSONObject(0).optString("text");

        day2 = data.getJSONObject(1).optString("day");
        high2 = data.getJSONObject(1).optInt("high");
        low2 = data.getJSONObject(1).optInt("low");
        text2=data.getJSONObject(1).optString("text");

        day3= data.getJSONObject(2).optString("day");
        high3 = data.getJSONObject(2).optInt("high");
        low3 = data.getJSONObject(2).optInt("low");
        text3=data.getJSONObject(2).optString("text");

        day4 = data.getJSONObject(3).optString("day");
        high4 = data.getJSONObject(3).optInt("high");
        low4 = data.getJSONObject(3).optInt("low");
        text4=data.getJSONObject(3).optString("text");

        day5 = data.getJSONObject(4).optString("day");
        high5 = data.getJSONObject(4).optInt("high");
        low5 = data.getJSONObject(4).optInt("low");
        text5=data.getJSONObject(4).optString("text");

    }
}
