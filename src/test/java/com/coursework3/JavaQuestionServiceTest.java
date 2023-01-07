package com.coursework3;

import com.coursework3.exception.QuestionNotFoundException;
import com.coursework3.model.Question;
import com.coursework3.repository.JavaQuestionRepository;
import com.coursework3.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {


    @Mock
    private JavaQuestionRepository repository;
    public static final String QUESTION = "test";
    public static final String ANSWER = "answer";
    public static final Question TEST = new Question("test", "answer");

    @InjectMocks
    private  JavaQuestionService service;

    @Test
    public void addTest() {
        when(repository.add(TEST)).thenReturn(TEST);
        assertEquals(service.add(QUESTION, ANSWER),TEST);
    }


    @Test
    public void removeTestException() {
        Question question = new Question(QUESTION, ANSWER);
        repository.add(question);
        Assertions.assertThrows(QuestionNotFoundException.class, () -> {
            service.remove(question);});
    }


    @Test
    public void getAllEmptyTest() {
        Set<Question> test = new HashSet<>();
        when(repository.getAll()).thenReturn(test);
        assertEquals(service.getAll(), test);
    }

    @Test
    public void getAllTest() {
        Set<Question> test = Set.of(TEST);
        when(repository.getAll()).thenReturn(test);
        assertTrue(service.getAll().containsAll(test));
    }

    @Test
    public void getRandomQuestionTest() {
        Set<Question> test = Set.of(TEST);
        when(repository.getAll()).thenReturn(test);
        Question test2 = service.getRandomQuestion();
        assertFalse(test2.equals(test));
    }

}
