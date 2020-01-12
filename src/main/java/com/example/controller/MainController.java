package com.example.controller;


import com.example.domain.City;
import com.example.domain.History;
import com.example.domain.User;
import com.example.domain.Weather;
import com.example.repos.CityRepo;
import com.example.repos.WeatherRepo;
import com.example.service.HistoryService;
import com.example.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Map;


@Controller
public class MainController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private HistoryService historyService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter, Model model) {
        City city;
        if (filter != null && !filter.isEmpty()) {
            city = cityRepo.findCityByName(filter);
        } else {
            city =  null;
        }
        if (user!=null){
            historyService.addHistory(city, user);
        }
        Weather weather = weatherService.getWeather(city);
        model.addAttribute("city", city);
        model.addAttribute("weather", weather);
        return "main";
    }
}
