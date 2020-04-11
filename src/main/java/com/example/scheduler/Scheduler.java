package com.example.scheduler;

import com.example.domain.City;
import com.example.domain.Weather;
import com.example.helper.HttpClientExample;
import com.example.repos.CityRepo;
import com.example.repos.WeatherRepo;
import com.example.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;


@Component
public class Scheduler {

    @Autowired
    private WeatherService weatherService;



    @Scheduled(cron = "0 0 */6 * * *") // Формат:  секунда, минута, час, день, месяц, день недели
    public void createWeather() throws Exception {
        weatherService.addWeather();
    }
}
