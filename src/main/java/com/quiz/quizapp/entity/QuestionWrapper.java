package com.quiz.quizapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionWrapper {
    Integer questionId;
    String questionTitle;
    String option1;
    String option2;
    String option3;
    String option4;
}
