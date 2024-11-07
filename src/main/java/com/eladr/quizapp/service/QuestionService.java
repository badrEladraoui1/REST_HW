package com.eladr.quizapp.service;

import com.eladr.quizapp.dao.entity.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {

     ResponseEntity<List<Question>> getAllQuestions();
     ResponseEntity<List<Question>> getQuestionsByCategory(String category);
     ResponseEntity<String> addQuestion(Question question);
     ResponseEntity<String> updateQuestion(long id , Question question);
}
