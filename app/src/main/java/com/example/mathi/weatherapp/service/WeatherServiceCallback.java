package com.example.mathi.weatherapp.service;

import com.example.mathi.weatherapp.data.Channel;

/**
 * Created by mathi on 19/01/2016.
 */
public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);

    void serviceFailure(Exception exception);
}