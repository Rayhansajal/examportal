package com.example.examportal.controller;

import com.example.examportal.models.exam.Question;
import com.example.examportal.models.exam.Quiz;
import com.example.examportal.service.QuestionService;
import com.example.examportal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;



@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizService quizService;
    // add question
    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));

    }

    // update question

    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question){

        return ResponseEntity.ok(this.questionService.updatQuestion(question));
    }

    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid){
//        Quiz quiz = new Quiz();
//        quiz.setqId(qid);
//     Set<Question> questionsOfQuiz= this.questionService.getQuestionsOfQuiz()


        Quiz quiz = this.quizService.getQuiz(qid);
        Set<Question> questions = quiz.getQuestions();
        List list = new ArrayList(questions);
        if(list.size() > Integer.parseInt(quiz.getNumberOfQuestion())){
            list.subList(0,Integer.parseInt(quiz.getNumberOfQuestion()+1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);

    }

    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionOfQuizAdmin(@PathVariable("qid") Long qid){

        Quiz quiz = new Quiz();
        quiz.setqId(qid);
     Set<Question> questionsOfQuiz= this.questionService.getQuestionsOfQuiz(quiz);
     return ResponseEntity.ok(questionsOfQuiz);




    }


    // get single question

   @GetMapping("/{quesId}")

    public Question get(@PathVariable("quesId") Long quesId){

        return this.questionService.getQuestion(quesId);
   }

   // delete question

    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") Long quesId){
        this.questionService.deleteQuestion(quesId);

    }

//    // eval quiz
//    @PostMapping("/eval-quiz")
//    public ResponseEntity<?>evalQuiz(@RequestBody List<Question> questions){
//        System.out.println(questions);
//        double marksGot=0;
//        int correctAnswers=0;
//        int attempted=0;
//        for (Question q: questions){
//            Question question = this.questionService.get(q.getQuesId());
//            if (question.getAnswer().trim().equals(q.getGivenAnswer().trim())){
//
//                correctAnswers++;
//
//                double markSingle=Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
//                marksGot +=markSingle;
//            }
//            if(q.getGivenAnswer()!=null ||q.getGivenAnswer().trim().equals(" ") ){
//                attempted++;
//            }
//
//        };
//
//            Map<String,Object> map=new HashMap<String,Object>( );
//            map.put("marksGot",marksGot);
//            map.put("correctAnswers",correctAnswers);
//            map.put("attempted",attempted);
//
//        return ResponseEntity.ok(map);
//    }

}
