package com.yeji.toeic_vova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DayController {

    @GetMapping("/day")
    public String day(
            @RequestParam String type,
            Model model) {

        model.addAttribute("type", type);

        return "day";
    }
}