package com.yeji.toeic_vova.controller;

import com.yeji.toeic_vova.entity.WrongWord;
import com.yeji.toeic_vova.repository.WrongWordRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReviewController {

    private final WrongWordRepository wrongWordRepository;

    public ReviewController(WrongWordRepository wrongWordRepository) {
        this.wrongWordRepository = wrongWordRepository;
    }

    @GetMapping("/review")
    public String review(Model model) {
        List<WrongWord> wrongWords = wrongWordRepository.findAll();

        model.addAttribute("wrongWords", wrongWords);

        return "review";
    }
    @GetMapping("/review/clear")
    public String clearReview() {

        wrongWordRepository.deleteAll();

        return "redirect:/review";
    }
}