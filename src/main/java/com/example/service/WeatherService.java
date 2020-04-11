package com.example.service;

import com.example.domain.City;
import com.example.domain.Weather;
import com.example.helper.HttpClientExample;
import com.example.repos.CityRepo;
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

import java.util.Date;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepo weatherRepo;

    @Autowired
    private HttpClientExample client;

    @Autowired
    private CityRepo cityRepo;

    public Weather getWeather(City city){
        if(city!=null){
            Weather weather = weatherRepo.findTopByCity_IdOrderByDateDesc(city.getId());
            return weather;
        }else {return null;}
    }

    public void addWeather() throws Exception{
        Iterable<City> list = cityRepo.findAll();
        for (City city: list) {
            Weather weather = new Weather();
            weather.setDate(new Date());
            weather.setCity(city);
            weather.setTemp(client.sendGet(city.getLat(), city.getLon()));
            weatherRepo.save(weather);

            System.out.println("save: " + weather.getCity().getName());
            Thread.sleep(1000);
        }
    }

}
