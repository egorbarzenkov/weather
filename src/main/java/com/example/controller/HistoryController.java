package com.example.controller;

import com.example.domain.History;
import com.example.domain.User;
import com.example.repos.HistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HistoryController {

    @Autowired
    private HistoryRepo historyRepo;


    @GetMapping("/history")
    public String greeting(Map<String, Object> model) {
        return "history";
    }

    @GetMapping("/main")
    public String main(@AuthenticationPrincipal User user, Model model) {
        Iterable<History> histories = historyRepo.findDistinctByUser(user);
        model.addAttribute("histories", histories);
        return "history";
    }
}
