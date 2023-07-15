package com.quiz.quizapp.service;

import com.quiz.quizapp.entity.Question;
import com.quiz.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    QuestionRepository questionRepository;
    @Override
    public Optional<Question> getQuestionById(int questionId) {
        return questionRepository.findById(questionId);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getQuestions(int numberOfQuestion) {
        return questionRepository.getQuestions(numberOfQuestion);
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }
}
