package com.coursework3;

import com.coursework3.model.Question;
import com.coursework3.service.ExaminerServiceImpl;
import com.coursework3.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExamServiceImplTest {
    @Mock
    JavaQuestionService javaQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    private Collection<Question> questions;

    @BeforeEach
    public void setUp() {
        questions = Set.of(
                new Question("test", "answer"),
                new Question("test2", "answer2"),
                new Question("test3", "answer3"),
                new Question("test4", "answer4"),
                new Question("test5", "answer5")
        );
        when(javaQuestionService.getAll()).thenReturn(questions);
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                new Question("test", "answer"),
                new Question("test2", "answer2"),
                new Question("test3", "answer3"),
                new Question("test4", "answer4"),
                new Question("test5", "answer5"));
    }

    @Test
    public void shouldReturnGetQuestions() {
        Assertions.assertEquals(examinerService.getQuestions(5), questions);
    }
}
