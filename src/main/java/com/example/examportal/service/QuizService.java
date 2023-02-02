package com.example.examportal.service;

import com.example.examportal.models.exam.Category;
import com.example.examportal.models.exam.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);

    public Quiz updatQuiz(Quiz quiz);

    public Set<Quiz> getQuizzes();


    public Quiz getQuiz(Long quizId);

    public void deleteQuiz(Long quizId);


    public List<Quiz> getQuizzesOfCategory(Category category);
    public List<Quiz> getActiveQuizzes();
    public List<Quiz> getActiveQuizzesOfCategory(Category c);
}
