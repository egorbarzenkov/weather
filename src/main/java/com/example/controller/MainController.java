package com.example.controller;


import com.example.domain.User;
import com.example.domain.Weather;
import com.example.repos.WeatherRepo;
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
    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Model model) {
        Weather weather = weatherService.getWeather();

//        Iterable<Message> messages = messageRepo.findAll();
//
//        if (filter != null && !filter.isEmpty()) {
//            messages = messageRepo.findByTag(filter);
//        } else {
//            messages = messageRepo.findAll();
//        }
//
//        model.addAttribute("messages", messages);
//        model.addAttribute("filter", filter);

        model.addAttribute("weather", weather);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user, Map<String, Object> model
    ) throws IOException {
//        Message message = new Message(text, tag, user);


//        messageRepo.save(message);

//        Iterable<Message> messages = messageRepo.findAll();

//        model.put("messages", messages);

        return "main";
    }
}
