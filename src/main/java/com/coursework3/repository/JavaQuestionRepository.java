package com.coursework3.repository;

import com.coursework3.model.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions = new HashSet<>();

    //    @PostConstruct
//    public void unit() {
//        questions.add(new Question("bla-bla", "ky-ky"));
//        questions.add(new Question("test-test", "answer"));
//        questions.add(new Question("hello", "bye"));
//    }
    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}