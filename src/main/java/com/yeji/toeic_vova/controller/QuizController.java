package com.yeji.toeic_vova.controller;

import com.yeji.toeic_vova.entity.Word;
import com.yeji.toeic_vova.repository.WordRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuizController {

    private final WordRepository wordRepository;

    public QuizController(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @GetMapping("/quiz")
    public String quiz(@RequestParam(defaultValue = "1") int day,
                       Model model,
                       HttpSession session) {

        if (session.getAttribute("loginUser") == null) {

           return "redirect:/login";
        }

        List<Word> words = wordRepository.findByDayNo(day);

        model.addAttribute("words", words);
        model.addAttribute("day", day);

        return "quiz";
    }
}