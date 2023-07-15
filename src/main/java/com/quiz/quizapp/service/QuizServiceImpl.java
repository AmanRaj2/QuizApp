package com.quiz.quizapp.service;

import com.quiz.quizapp.entity.*;
import com.quiz.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService{
    @Autowired
    QuestionService questionService;
    @Autowired
    QuizRepository quizRepository;

    @Override
    public QuizWrapper createQuiz(int numberOfQuestions, String title) {
        List<Question> questions = questionService.getQuestions(numberOfQuestions);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        Quiz quizDB = quizRepository.save(quiz);
        return quizToWrapper(quizDB);
    }

    @Override
    public QuizWrapper getQuizById(int quizId) {
        Quiz quiz = quizRepository.findById(quizId).orElse(new Quiz());
        return quizToWrapper(quiz);
    }

    @Override
    public int submitQuiz(int quizId, List<QuestionResponse> questionResponseList) {
        int rightAns = 0;
        Quiz quiz = quizRepository.findById(quizId).orElse(new Quiz());
        HashMap<Integer,String> questionAns = new HashMap<>();
        for(Question q : quiz.getQuestions()){
            questionAns.put(q.getQuestionId(),q.getRightAnswer());
        }

        for(QuestionResponse response : questionResponseList){
            if(questionAns.containsKey(response.getQuestionId())){
                if(response.getSubmittedAns().equals(questionAns.get(response.getQuestionId()))){
                    rightAns++;
                }
            }
        }
        return rightAns;
    }

    public QuizWrapper quizToWrapper(Quiz quizDB){
        if(quizDB == null){
            return null;
        }
        QuizWrapper quizWrapper = new QuizWrapper();
        List<QuestionWrapper> wrapperQuestions= new ArrayList<>();
        List<Question> questionsDB = quizDB.getQuestions();

        for(Question q : questionsDB){
            QuestionWrapper questionWrapper = new QuestionWrapper(q.getQuestionId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            wrapperQuestions.add(questionWrapper);
        }
        quizWrapper.setQuizId(quizDB.getQuizId());
        quizWrapper.setTitle(quizDB.getTitle());
        quizWrapper.setQuestionsWrapper(wrapperQuestions);
        return quizWrapper;
    }

}
