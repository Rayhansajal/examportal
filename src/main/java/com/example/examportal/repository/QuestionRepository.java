package com.example.examportal.repository;

import com.example.examportal.models.exam.Question;
import com.example.examportal.models.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
