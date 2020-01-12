package com.example.service;

import com.example.domain.City;
import com.example.domain.History;
import com.example.domain.User;
import com.example.domain.Weather;
import com.example.repos.HistoryRepo;
import com.example.repos.WeatherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepo repo;

    public void addHistory(City city, User user){
        History history = new History();
        history.setUser(user);
        history.setCity(city);
        repo.save(history);
    }
}
