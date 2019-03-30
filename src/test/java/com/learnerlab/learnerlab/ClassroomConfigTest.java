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
public class ClassroomConfigTest {

    @Autowired
    @Qualifier("students")
    Students students;

    @Autowired
    @Qualifier("previousStudents")
    Students prevStudents;

    @Autowired
    @Qualifier("instructors")
    Instructors instructors;

    @Test
    public void currentCohortStudentsTest(){
        //given
        ClassroomConfig cc = new ClassroomConfig();
        //when
        Classroom classroom = cc.currentCohort(instructors,students);
        Students actual = classroom.getStudents();
        //then
        Assert.assertEquals(students, actual);
    }

    @Test
    public void currentCohortInstructorsTest(){
        //given
        ClassroomConfig cc = new ClassroomConfig();
        //when
        Classroom classroom = cc.currentCohort(instructors,students);
        Instructors actual = classroom.getInstructors();
        //then
        Assert.assertEquals(instructors,actual);
    }

    @Test
    public void previousCohortStudentsTest(){
        //given
        ClassroomConfig cc = new ClassroomConfig();
        //when
        Classroom classroom = cc.previousCohort(instructors,prevStudents);
        Students actual = classroom.getStudents();
        //then
        Assert.assertEquals(prevStudents, actual);
    }

    @Test
    public void previousCohortInstructorsTest(){
        //given
        ClassroomConfig cc = new ClassroomConfig();
        //when
        Classroom classroom = cc.previousCohort(instructors,students);
        Instructors actual = classroom.getInstructors();
        //then
        Assert.assertEquals(instructors,actual);
    }
}
