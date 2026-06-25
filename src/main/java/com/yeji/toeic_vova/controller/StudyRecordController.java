package com.yeji.toeic_vova.controller;

import com.yeji.toeic_vova.entity.QuizScore;
import com.yeji.toeic_vova.entity.User;
import com.yeji.toeic_vova.repository.QuizScoreRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudyRecordController {

    private final QuizScoreRepository quizScoreRepository;

    public StudyRecordController(QuizScoreRepository quizScoreRepository) {
        this.quizScoreRepository = quizScoreRepository;
    }

    @GetMapping("/study-record")
    public String studyRecord(HttpSession session, Model model) {

        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser == null) {
            return "redirect:/login";
        }

        List<QuizScore> scoreList =
                quizScoreRepository.findByUserOrderByDayNoAsc(loginUser);

        int progress = (scoreList.size() * 100) / 20;

        model.addAttribute("username", loginUser.getUsername());
        model.addAttribute("progress", progress);
        model.addAttribute("scoreList", scoreList);

        return "study-record";
    }
}