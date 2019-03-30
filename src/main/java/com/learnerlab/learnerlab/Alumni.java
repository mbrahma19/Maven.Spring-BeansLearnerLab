package com.learnerlab.learnerlab;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Alumni {

    private Students students;
    private Instructors instructors;

    public Alumni(Instructors instructors, @Qualifier("previousStudents") Students students){
        this.instructors = instructors;
        this.students = students;
    }

    @PostConstruct
    public void executeBootCamp(){
        List<Student> studentList = students.findAll();
        List<Instructor> instructorList = instructors.findAll();
        int numberOfInstructors = instructors.size();
        int numberOfStudents = students.size();
        double numberOfHoursToTeachEachStudent = 1200;
        double numberOfHoursToTeach = numberOfHoursToTeachEachStudent * numberOfStudents;
        double numberOfHoursPerInstructor = numberOfHoursToTeach / numberOfInstructors;

        studentList.forEach(s -> s.learn(numberOfHoursToTeachEachStudent));
        instructorList.forEach(t -> t.updateHoursTaught(numberOfHoursPerInstructor));
    }

    public Students getStudents() {
        return students;
    }

    public Instructors getInstructors() {
        return instructors;
    }
}
