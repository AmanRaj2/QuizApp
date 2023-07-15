package com.quiz.quizapp.repository;

import com.quiz.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {

    public static final String query1 = "SELECT * FROM (SELECT * FROM QUESTION ORDER BY DBMS_RANDOM.RANDOM) WHERE ROWNUM< :numberOfQuestion + 1";
    @Query(value = query1, nativeQuery = true)
    List<Question> getQuestions(int numberOfQuestion);
}

