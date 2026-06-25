package com.yeji.toeic_vova.repository;

import com.yeji.toeic_vova.entity.QuizScore;
import com.yeji.toeic_vova.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuizScoreRepository extends JpaRepository<QuizScore, Long> {

    Optional<QuizScore> findByUserAndDayNo(User user, Integer dayNo);

    List<QuizScore> findByUserOrderByDayNoAsc(User user);
}