package com.coursework3.service;

import com.coursework3.exception.QuestionNotFoundException;
import com.coursework3.exception.QuestionOnListException;
import com.coursework3.model.Question;
import com.coursework3.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService{
    private final QuestionRepository questions;
    private final Random random = new Random();

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.getAll().contains(question)){
            throw new QuestionOnListException("Такой вопрос есть в списке вопросов для экзамена");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.getAll().contains(question)) {
            throw new QuestionNotFoundException("Данного вопроса нет в списке вопросов для экзамена");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return new ArrayList<>(questions.getAll()).get(random.nextInt(questions.getAll().size()));
    }
}