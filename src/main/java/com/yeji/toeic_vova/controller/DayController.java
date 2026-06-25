package com.yeji.toeic_vova.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DayController {

    @GetMapping("/day")
    public String day(
            @RequestParam(required = false) String type,
            Model model,
            HttpSession session) {

        if (session.getAttribute("loginUser") == null) {
            return "redirect:/login";
        }

        if (type == null || type.isBlank()) {
            return "redirect:/";
        }

        model.addAttribute("type", type);

        return "day";
    }
}