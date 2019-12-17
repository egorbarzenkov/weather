package com.example.service;

import com.example.domain.Weather;
import com.example.helper.HttpClientExample;
import com.example.repos.WeatherRepo;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepo weatherRepo;

    @Autowired
    private HttpClientExample httpClientExample;

    public Weather getWeather(){

//        if(weatherRepo.findTopByOrderByDate().getDate()==date()){null;}

        Weather weather = new Weather();
        weatherRepo.save(weather);
        return weather;
    }

    public Date date(){
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.HOUR, 1);
        return c.getTime();
    }


}
