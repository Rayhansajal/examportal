package com.example.examportal.controller;

import com.example.examportal.models.exam.Category;
import com.example.examportal.models.exam.Quiz;
import com.example.examportal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    // add quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));

    }
    // upadte quiz
    @PutMapping("/")
    public  ResponseEntity<Quiz> update(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.updatQuiz(quiz));
    }
    // get quiz
    @GetMapping("/")
    public ResponseEntity<?> quizzes(){
        return ResponseEntity.ok(this.quizService.getQuizzes());

    }

    // get single quiz

    @GetMapping("/{qid}")
    public Quiz quiz(@PathVariable("qid") Long qid)
    {

        return this.quizService.getQuiz(qid);
    }
    @DeleteMapping("/{qid}")
    public void delete(@PathVariable("qid") Long qid){
        this.quizService.deleteQuiz(qid);

    }

    // get category
    @GetMapping("/category/{cid}")
    public List<Quiz>getQuizzesOfCategory(@PathVariable("cid")Long cid){

        Category category = new Category();
        category.setCid(cid);
        return this.quizService.getQuizzesOfCategory(category);
    }

    // get active quiz
    @GetMapping("/active")
    public List<Quiz>getActiveQuizzes(){
        return this.quizService.getActiveQuizzes();
    }
    @GetMapping("/category/active/{cid}")
    public List<Quiz>getActiveQuizzes(@PathVariable("cid") Long cid){
        Category category = new Category();
        category.setCid(cid);

        return this.quizService.getActiveQuizzesOfCategory(category);
    }


}
