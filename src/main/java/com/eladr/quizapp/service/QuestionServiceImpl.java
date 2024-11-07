package com.eladr.quizapp.service;

import com.eladr.quizapp.dao.entity.Question;
import com.eladr.quizapp.dao.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepo questionRepo;


    @Override
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionRepo.findAll() , HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category){
        try {
            return new ResponseEntity<>(questionRepo.findByCategory(category) , HttpStatus.OK) ;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> addQuestion(Question question){
        questionRepo.save(question);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateQuestion(long id, Question question) {
        Optional<Question> questionToUpdate = questionRepo.findById(id);
        if(questionToUpdate.isPresent()) {
            Question questionINeed = questionToUpdate.get();
            questionINeed.setCategory(question.getCategory());
            questionINeed.setDifficultyLevel(question.getDifficultyLevel());
            questionINeed.setOption1(question.getOption1());
            questionINeed.setOption2(question.getOption2());
            questionINeed.setOption3(question.getOption3());
            questionINeed.setOption4(question.getOption4());
            questionINeed.setQuestionTitle(question.getQuestionTitle());
            questionINeed.setRightAnswer(question.getRightAnswer());

            questionRepo.save(questionINeed);

            return new ResponseEntity<>("Question updated successfully",HttpStatus.CREATED);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
        }
    }

    public ResponseEntity<String> deleteQuestion(long id){
        questionRepo.deleteById(id);
        return new ResponseEntity<>("Deleted !!!",HttpStatus.OK);
    }

}
