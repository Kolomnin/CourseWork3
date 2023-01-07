package com.coursework3.service;

import com.coursework3.exception.ExceedsNumberQuestionsInListException;
import com.coursework3.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final List<QuestionService> questionService;
    private final Random random = new Random();

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService questionService,
                               @Qualifier("mathQuestionService") QuestionService questionService2) {
        this.questionService = List.of(questionService,questionService2);
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.size() || amount <=0) {
            throw new ExceedsNumberQuestionsInListException("Количество вопросов превышает количество вопросов в списке");
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount){
            questions.add(questionService.get(amount).getRandomQuestion());
        }
        return questions;
    }
}
