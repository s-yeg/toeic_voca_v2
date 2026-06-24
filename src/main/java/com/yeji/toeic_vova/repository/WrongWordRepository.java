package com.yeji.toeic_vova.repository;

import com.yeji.toeic_vova.entity.WrongWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WrongWordRepository
        extends JpaRepository<WrongWord, Long> {
    boolean existsByWord(String word);
}