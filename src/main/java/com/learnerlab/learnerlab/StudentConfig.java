package com.learnerlab.learnerlab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean(name ="students")
    public Students currentStudents(){

        List<Student> list = new ArrayList<>();
        list.add(new Student(1l, "Marci Brahma"));
        list.add(new Student(2l, "McTina McClintock"));
        list.add(new Student(3l, "Marc Cruz"));
        list.add(new Student(4l, "Chalie Wilmer"));
        list.add(new Student(5l, "Mike Krohn"));
        list.add(new Student(6l, "Sean RowRowRowYourBoat"));

        return new Students(list);
    }

    @Bean(name = "previousStudents")
    public Students previousStudents(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(10l, "Who dat who dat"));
        list.add(new Student(11l, "I-G-G-Y"));
        list.add(new Student(12l, "Khalil"));
        list.add(new Student(13l, "Kevin"));
        list.add(new Student(14l, "Ned"));
        list.add(new Student(15l, "Demetrius"));

        return new Students(list);
    }
}
