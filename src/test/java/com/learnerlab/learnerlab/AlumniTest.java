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
public class AlumniTest {

    @Autowired
    @Qualifier("previousStudents")
    Students students;

    @Autowired
    @Qualifier("usInstructors")
    Instructors instructors;

    @Test
    public void executeBootCampTest(){
        //given
        Double expected = students.findAll().get(0).getTotalStudyTime() +1200;
        //when
        Alumni alumni = new Alumni(instructors,students);

        alumni.executeBootCamp();
        //when
        //then
        for (Student s : students) {
            Assert.assertEquals(expected,s.getTotalStudyTime());
        }
    }

    @Test
    public void executeBootCampTeachersTest(){
        //given
        int numberOfInstructors = instructors.size();
        int numberOfStudents = students.size();
        double numberOfHoursToTeach = 1200 * numberOfStudents;
        double numberOfHoursPerInstructor = numberOfHoursToTeach / numberOfInstructors;
        Double expected = instructors.findAll().get(0).getNumbersOfHoursTaught() + numberOfHoursPerInstructor;
        //when
        Alumni alumni = new Alumni(instructors,students);

        alumni.executeBootCamp();
        //when
        //then
        for (Instructor s : instructors) {
            Assert.assertEquals(expected,s.getNumbersOfHoursTaught());
        }
    }
}
