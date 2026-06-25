package com.yeji.toeic_vova.repository;

import com.yeji.toeic_vova.entity.User;
import com.yeji.toeic_vova.entity.WrongWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WrongWordRepository extends JpaRepository<WrongWord, Long> {

    List<WrongWord> findByUser(User user);

    List<WrongWord> findByUserAndDayNo(User user, Integer dayNo);

    boolean existsByWordAndUser(String word, User user);
}