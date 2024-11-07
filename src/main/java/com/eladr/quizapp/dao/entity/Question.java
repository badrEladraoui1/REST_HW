package com.eladr.quizapp.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    @Column(name = "difficulty_level")
    private String difficultyLevel;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    @Column(name = "question_title")
    private String questionTitle;

    private String rightAnswer;

}
