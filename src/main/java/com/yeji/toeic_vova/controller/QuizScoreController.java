package com.yeji.toeic_vova.controller;

import com.yeji.toeic_vova.entity.QuizScore;
import com.yeji.toeic_vova.entity.User;
import com.yeji.toeic_vova.repository.QuizScoreRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
public class QuizScoreController {

    private final QuizScoreRepository quizScoreRepository;

    public QuizScoreController(QuizScoreRepository quizScoreRepository) {
        this.quizScoreRepository = quizScoreRepository;
    }

    @PostMapping("/quiz-score")
    @ResponseBody
    public void saveScore(@RequestBody Map<String, Integer> data,
                          HttpSession session) {

        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser == null) {
            return;
        }

        Integer dayNo = data.get("dayNo");
        Integer score = data.get("score");

        Optional<QuizScore> optionalScore =
                quizScoreRepository.findByUserAndDayNo(loginUser, dayNo);

        if (optionalScore.isPresent()) {
            QuizScore quizScore = optionalScore.get();

            if (score > quizScore.getScore()) {
                quizScore.setScore(score);
                quizScoreRepository.save(quizScore);
            }

        } else {
            QuizScore quizScore = new QuizScore();
            quizScore.setUser(loginUser);
            quizScore.setDayNo(dayNo);
            quizScore.setScore(score);

            quizScoreRepository.save(quizScore);
        }
    }
}