package com.quiz.quizapp.service;

import com.quiz.quizapp.entity.QuestionResponse;
import com.quiz.quizapp.entity.Quiz;
import com.quiz.quizapp.entity.QuizWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {
    public QuizWrapper createQuiz(int numberOfQuestions, String title);

    QuizWrapper getQuizById(int quizId);

    int submitQuiz(int quizId, List<QuestionResponse> questionResponseList);
}
