package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HistoryController {


    @GetMapping("/history")
    public String greeting(Map<String, Object> model) {
        return "history";
    }
}
