package com.quiz.quizapp.entity;

import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
public class QuizWrapper {
    int quizId;
    String title;
    List<QuestionWrapper> questionsWrapper;
}
