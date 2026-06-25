package com.yeji.toeic_vova.controller;

import com.yeji.toeic_vova.entity.User;
import com.yeji.toeic_vova.entity.WrongWord;
import com.yeji.toeic_vova.repository.WrongWordRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReviewController {

    private final WrongWordRepository wrongWordRepository;

    public ReviewController(WrongWordRepository wrongWordRepository) {
        this.wrongWordRepository = wrongWordRepository;
    }

    @GetMapping("/review")
    public String review(
            @RequestParam(required = false) Integer day,
            Model model,
            HttpSession session) {

        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser == null) {
            return "redirect:/login";
        }

        if (day != null) {
            List<WrongWord> wrongWords =
                    wrongWordRepository.findByUserAndDayNo(loginUser, day);

            model.addAttribute("wrongWords", wrongWords);
        }

        model.addAttribute("selectedDay", day);

        return "review";
    }

    @GetMapping("/review/clear")
    public String clearReview(HttpSession session) {

        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser == null) {
            return "redirect:/login";
        }

        List<WrongWord> wrongWords = wrongWordRepository.findByUser(loginUser);
        wrongWordRepository.deleteAll(wrongWords);

        return "redirect:/review";
    }
}