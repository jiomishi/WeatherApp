package com.example.mathi.weatherapp;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathi.weatherapp.data.Atmosphere;
import com.example.mathi.weatherapp.data.Channel;
import com.example.mathi.weatherapp.data.Forecast;
import com.example.mathi.weatherapp.data.Item;
import com.example.mathi.weatherapp.data.Wind;
import com.example.mathi.weatherapp.service.WeatherServiceCallback;
import com.example.mathi.weatherapp.service.YahooWeatherService;


public class HomeActivity extends ActionBarActivity implements WeatherServiceCallback {

    private ImageView weatherIconImageView;
    private TextView temperatureTextView;
    private TextView conditionTextView;
    private TextView locationTextView;
    private TextView speedTextView;
    private TextView humidityTextView;
    private TextView visibilityTextView;
    private TextView highTextView;
    private TextView lowTextView;


    private TextView day1TextView;
    private TextView highDay1TextView;
    private TextView lowDay1TextView;
    private TextView conditionDay1TextView;

    private TextView day2TextView;
    private TextView highDay2TextView;
    private TextView lowDay2TextView;
    private TextView conditionDay2TextView;

    private TextView day3TextView;
    private TextView highDay3TextView;
    private TextView lowDay3TextView;
    private TextView conditionDay3TextView;

    private TextView day4TextView;
    private TextView highDay4TextView;
    private TextView lowDay4TextView;
    private TextView conditionDay4TextView;

    private TextView day5TextView;
    private TextView highDay5TextView;
    private TextView lowDay5TextView;
    private TextView conditionDay5TextView;

    private YahooWeatherService service;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        weatherIconImageView = (ImageView) findViewById(R.id.weatherIconImageView);
        temperatureTextView = (TextView) findViewById(R.id.temperatureTextView);
        conditionTextView = (TextView) findViewById(R.id.conditionTextView);
        locationTextView = (TextView) findViewById(R.id.locationTextView);
        speedTextView=(TextView) findViewById(R.id.speedTextView);
        humidityTextView=(TextView) findViewById(R.id.humidityTextView);
        visibilityTextView=(TextView) findViewById(R.id.visibilityTextView);
        highTextView=(TextView) findViewById(R.id.highTextView);
        lowTextView=(TextView) findViewById(R.id.lowTextView);

        day1TextView =(TextView) findViewById(R.id.day1TextView);
        highDay1TextView=(TextView) findViewById(R.id.highDay1TextView);
        lowDay1TextView=(TextView) findViewById(R.id.lowDay1TextView);
        conditionDay1TextView=(TextView) findViewById(R.id.conditionDay1TextView);

        day2TextView =(TextView) findViewById(R.id.day2TextView);
        highDay2TextView=(TextView) findViewById(R.id.highDay2TextView);
        lowDay2TextView=(TextView) findViewById(R.id.lowDay2TextView);
        conditionDay2TextView=(TextView) findViewById(R.id.conditionDay2TextView);

        day3TextView =(TextView) findViewById(R.id.day3TextView);
        highDay3TextView=(TextView) findViewById(R.id.highDay3TextView);
        lowDay3TextView=(TextView) findViewById(R.id.lowDay3TextView);
        conditionDay3TextView=(TextView) findViewById(R.id.conditionDay3TextView);

        day4TextView =(TextView) findViewById(R.id.day4TextView);
        highDay4TextView=(TextView) findViewById(R.id.highDay4TextView);
        lowDay4TextView=(TextView) findViewById(R.id.lowDay4TextView);
        conditionDay4TextView=(TextView) findViewById(R.id.conditionDay4TextView);

        day5TextView =(TextView) findViewById(R.id.day5TextView);
        highDay5TextView=(TextView) findViewById(R.id.highDay5TextView);
        lowDay5TextView=(TextView) findViewById(R.id.lowDay5TextView);
        conditionDay5TextView=(TextView) findViewById(R.id.conditionDay5TextView);





        service = new YahooWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        service.refreshWeather("Paris, France");
    }

    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();

        Item item = channel.getItem();
        Wind wind=channel.getWind();
        Atmosphere atmosphere=channel.getAtmosphere();
        Forecast forecast = item.getForecast();


        int resourceId = getResources().getIdentifier("drawable/icon_" + item.getCondition().getCode(), null, getPackageName());

        @SuppressWarnings("deprecation")
        Drawable weatherIconDrawble = getResources().getDrawable(resourceId);

        weatherIconImageView.setImageDrawable(weatherIconDrawble);

        temperatureTextView.setText(item.getCondition().getTemperature() + "\u00B0" + channel.getUnits().getTemperature());
        conditionTextView.setText(item.getCondition().getDescription());
        locationTextView.setText(service.getLocation());
        speedTextView.setText(wind.getSpeed() + " " + channel.getUnits().getSpeed());
        humidityTextView.setText(atmosphere.getHumidity()+"%");
        visibilityTextView.setText(atmosphere.getVisibility() + " " + channel.getUnits().getDistance());
        highTextView.setText(forecast.getHigh1()+"\u00B0" + channel.getUnits().getTemperature());
        lowTextView.setText(forecast.getLow1()+ "\u00B0" + channel.getUnits().getTemperature());


        day1TextView.setText(forecast.getDay1());
        highDay1TextView.setText(forecast.getHigh1()+"\u00B0" + channel.getUnits().getTemperature());
        lowDay1TextView.setText(forecast.getLow1()+ "\u00B0" + channel.getUnits().getTemperature());
        conditionDay1TextView.setText(forecast.getText1());

        day2TextView.setText(forecast.getDay2());
        highDay2TextView.setText(forecast.getHigh2()+"\u00B0" + channel.getUnits().getTemperature());
        lowDay2TextView.setText(forecast.getLow2()+ "\u00B0" + channel.getUnits().getTemperature());
        conditionDay2TextView.setText(forecast.getText2());

        day3TextView.setText(forecast.getDay3());
        highDay3TextView.setText(forecast.getHigh3()+"\u00B0" + channel.getUnits().getTemperature());
        lowDay3TextView.setText(forecast.getLow3()+ "\u00B0" + channel.getUnits().getTemperature());
        conditionDay3TextView.setText(forecast.getText3());

        day4TextView.setText(forecast.getDay4());
        highDay4TextView.setText(forecast.getHigh4()+"\u00B0" + channel.getUnits().getTemperature());
        lowDay4TextView.setText(forecast.getLow4()+ "\u00B0" + channel.getUnits().getTemperature());
        conditionDay4TextView.setText(forecast.getText4());

        day5TextView.setText(forecast.getDay5());
        highDay5TextView.setText(forecast.getHigh5()+"\u00B0" + channel.getUnits().getTemperature());
        lowDay5TextView.setText(forecast.getLow5()+ "\u00B0" + channel.getUnits().getTemperature());
        conditionDay5TextView.setText(forecast.getText5());





    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }
}
