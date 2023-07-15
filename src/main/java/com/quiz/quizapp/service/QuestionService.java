package com.quiz.quizapp.service;

import com.quiz.quizapp.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface QuestionService {
    Optional<Question> getQuestionById(int questionId);
    List<Question> getAllQuestion();
    List<Question> getQuestions(int numberOfQuestion);

    Question addQuestion(Question question);
}
