package com.yeji.toeic_vova.controller;

import com.yeji.toeic_vova.entity.User;
import com.yeji.toeic_vova.entity.WrongWord;
import com.yeji.toeic_vova.repository.WrongWordRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WrongWordController {

    private final WrongWordRepository wrongWordRepository;

    public WrongWordController(WrongWordRepository wrongWordRepository) {
        this.wrongWordRepository = wrongWordRepository;
    }

    @PostMapping("/wrong-word")
    @ResponseBody
    public void saveWrongWord(
            @RequestBody WrongWord wrongWord,
            HttpSession session) {

        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser == null) {
            return;
        }

        wrongWord.setUser(loginUser);

        if (!wrongWordRepository.existsByWordAndUser(
                wrongWord.getWord(),
                loginUser)) {

            wrongWordRepository.save(wrongWord);
        }
    }
}