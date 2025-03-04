package com.springboot.quizApp.dao;

import com.springboot.quizApp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer > {


    List<Question> findByCategory(String Category);

    @Query(value = "SELECT * FROM questiondb q Where q.category=:category ORDER BY RAND() LIMIT :numQ",nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);

}
