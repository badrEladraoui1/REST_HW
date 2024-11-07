package com.eladr.quizapp.dao.repository;

import com.eladr.quizapp.dao.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

    List<Question> findByCategory(String category);
}
