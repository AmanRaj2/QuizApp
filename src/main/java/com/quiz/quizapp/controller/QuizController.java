package com.quiz.quizapp.controller;

import com.quiz.quizapp.entity.QuestionResponse;
import com.quiz.quizapp.entity.Quiz;
import com.quiz.quizapp.entity.QuizWrapper;
import com.quiz.quizapp.service.QuizService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/createQuiz")
    public QuizWrapper createQuiz(@RequestParam("numQ") int numberOfQuestions, @RequestParam("title") String title){
        return quizService.createQuiz(numberOfQuestions,title);
    }

    @GetMapping("/getQuizById/{quizId}")
    public QuizWrapper getQuizById (@PathVariable int quizId){
        return quizService.getQuizById(quizId);
    }
    @PostMapping("/submitQuiz/{quizId}")
    public int submitQuiz(@PathVariable int quizId, @RequestBody List<QuestionResponse> questionResponseList){
        return quizService.submitQuiz(quizId,questionResponseList);
    }
    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }
}
