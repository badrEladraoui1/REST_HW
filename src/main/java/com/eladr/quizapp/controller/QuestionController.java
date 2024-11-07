package com.eladr.quizapp.controller;

import com.eladr.quizapp.dao.entity.Question;
import com.eladr.quizapp.service.QuestionServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionServiceImpl questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{categoryMame}")
    public ResponseEntity<List<Question>> getAllQuestionsByPathVariable(@PathVariable String categoryMame){
        return questionService.getQuestionsByCategory(categoryMame);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Question>> getAllQuestionsByPathParam(@PathParam("categoryMame") String categoryMame){
        return questionService.getQuestionsByCategory(categoryMame);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable long id , @RequestBody Question question){
        return  questionService.updateQuestion(id , question);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable long id){
        return  questionService.deleteQuestion(id);
    }

}
