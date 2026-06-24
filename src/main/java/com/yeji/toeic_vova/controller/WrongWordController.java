package com.yeji.toeic_vova.controller;

import com.yeji.toeic_vova.entity.WrongWord;
import com.yeji.toeic_vova.repository.WrongWordRepository;
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
    public void saveWrongWord(@RequestBody WrongWord wrongWord) {

        if (!wrongWordRepository.existsByWord(wrongWord.getWord())) {
            wrongWordRepository.save(wrongWord);
        }

    }
}