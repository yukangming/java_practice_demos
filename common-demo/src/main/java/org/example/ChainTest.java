package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 责任链模式
 */
public class ChainTest {

    @Data
    class Student {
        private String classroom;
        private int score;
        public Student(String classroom, int score) {
            this.classroom = classroom;
            this.score = score;
        }
    }
    private List<RequestHandler> handlers;

    public void addHandler(RequestHandler handler) {
        handlers.add(handler);
    }


    public void processRequest(String request) {
        for (RequestHandler handler : handlers) {
            handler.processRequest(request);
        }
        List<Student> students = new ArrayList<>();
        students.stream().collect(Collectors.groupingBy(Student::getClassroom, Collectors.summingInt(Student::getScore)));

    }
}
