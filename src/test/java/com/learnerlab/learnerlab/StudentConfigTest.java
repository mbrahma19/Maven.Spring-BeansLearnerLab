package com.learnerlab.learnerlab;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentConfigTest {

    @Autowired
    @Qualifier("students")
    Students students;

    @Autowired
    @Qualifier("previousStudents")
    Students prevStudents;

    @Test
    public void currentStudentsSizeTest(){
        //given
        Integer expected = 6;
        //then
        Integer actual = students.findAll().size();
        //when
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void currentStudentsContainsTest(){
        //given
        String expected = "Marci Brahma";
        //then
        Student student = students.findAll().get(0);
        String actual = student.getName();
        //when
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void previousStudentsSizeTest(){
        //given
        Integer expected = 6;
        //then
        Integer actual = prevStudents.findAll().size();
        //when
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void previousStudentsContainsTest(){
        //given
        String expected = "Who dat who dat";
        //then
        Student student = prevStudents.findAll().get(0);
        String actual = student.getName();
        //when
        Assert.assertEquals(expected,actual);
    }

}
