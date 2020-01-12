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
    private HttpClientExample client;

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private WeatherRepo weatherRepo;

//    @Scheduled(cron = "*/3 * * * * *") // Формат:  секунда, минута, час, день, месяц, день недели
//    public void reportCurrentData() {
//        System.out.println("Scheduler working: " + new Date());
//    }


    @Scheduled(cron = "0 0 */6 * * *") // Формат:  секунда, минута, час, день, месяц, день недели
    public void createWeather() throws Exception {
        Iterable<City> list = cityRepo.findAll();
        for (City city: list) {
            Weather weather = new Weather();
            weather.setDate(new Date());
            weather.setCity(city);
            weather.setTemp(client.sendGet(city.getLat(), city.getLon()));
            weatherRepo.save(weather);

            System.out.println("Scheduler save: " + weather.getCity().getName());
            Thread.sleep(1000);
        }
//        System.out.println("Scheduler work: " + new Date());
    }
}
