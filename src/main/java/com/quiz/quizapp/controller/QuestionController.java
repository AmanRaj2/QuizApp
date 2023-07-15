package com.quiz.quizapp.controller;

import com.quiz.quizapp.entity.Question;
import com.quiz.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestion();
    }

    @PostMapping("/addQuestion")
    public Question addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @GetMapping("/getQuestionById/{id}")
    public Optional<Question> getQuestionById(@PathVariable("id") int questionId){
        return questionService.getQuestionById(questionId);
    }

    @GetMapping("/getQuestions/{numQ}")
    public List<Question> getQuestionForQuiz(@PathVariable("numQ") int numberOfQuestions){
        return questionService.getQuestions(numberOfQuestions);
    }

}
