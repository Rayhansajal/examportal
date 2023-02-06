package com.example.examportal.service;

import com.example.examportal.models.exam.Question;
import com.example.examportal.models.exam.Quiz;

import java.util.Set;

public interface QuestionService {

    public Question addQuestion(Question question);

    public Question updatQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(Long questionId);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

    public void deleteQuestion(Long quesId);


    public Question get(Long questionsId);


}
