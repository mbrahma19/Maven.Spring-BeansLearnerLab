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
public class InstructorConfigTest {

    @Autowired
    @Qualifier("usInstructors")
    Instructors usInstructors;

    @Autowired
    @Qualifier("ukInstructors")
    Instructors ukInstructors;

    @Autowired
    @Qualifier("instructors")
    Instructors instructors;

    @Test
    public void instructorsSizeTest(){
        //given
        Integer expected = 6;
        //when
        Integer actual = instructors.size();
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void instructorsContainsTest(){
        //given
        String expected0 = "Nhu";
        String expected1 = "Wilhelm";
        String expected2 = "Kris";
        String expected3 = "Dolio";
        String expected4 = "Leon";
        String expected5 = "Froilan";
        //when
        String actual0 = instructors.findAll().get(0).getName();
        String actual1 = instructors.findAll().get(1).getName();
        String actual2 = instructors.findAll().get(2).getName();
        String actual3 = instructors.findAll().get(3).getName();
        String actual4 = instructors.findAll().get(4).getName();
        String actual5 = instructors.findAll().get(5).getName();
        //then
        Assert.assertEquals(expected0,actual0);
        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected2,actual2);
        Assert.assertEquals(expected3,actual3);
        Assert.assertEquals(expected4,actual4);
        Assert.assertEquals(expected5,actual5);
    }

    @Test
    public void usInstructorsSizeTest(){
        //given
        Integer expected = 3;
        //when
        Integer actual = usInstructors.size();
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void usInstructorsContainsTest(){
        String expected0 = "Nhu";
        String expected1 = "Wilhelm";
        String expected2 = "Kris";
        //when
        String actual0 = usInstructors.findAll().get(0).getName();
        String actual1 = usInstructors.findAll().get(1).getName();
        String actual2 = usInstructors.findAll().get(2).getName();
        //then
        Assert.assertEquals(expected0,actual0);
        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected2,actual2);
    }

    @Test
    public void ukInstructorsSizeTest(){
        //given
        Integer expected = 3;
        //when
        Integer actual = ukInstructors.size();
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void uknstructorsContainsTest(){
        String expected3 = "Dolio";
        String expected4 = "Leon";
        String expected5 = "Froilan";
        //when
        String actual3 = ukInstructors.findAll().get(0).getName();
        String actual4 = ukInstructors.findAll().get(1).getName();
        String actual5 = ukInstructors.findAll().get(2).getName();
        //then
        Assert.assertEquals(expected3,actual3);
        Assert.assertEquals(expected4,actual4);
        Assert.assertEquals(expected5,actual5);
    }
}
