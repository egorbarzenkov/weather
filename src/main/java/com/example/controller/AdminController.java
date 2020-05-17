package com.example.controller;


import com.example.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;


@Controller
public class AdminController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/admin")
    public String greeting(Map<String, Object> model) {
        return "admin";
    }

    @GetMapping("/adminUpd")
    public String main(Model model) throws Exception {
        Runnable r = ()->{
            try{
                weatherService.addWeather();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        Thread myThread = new Thread(r,"MyThread");
        myThread.start();
        return "admin";
    }
}
