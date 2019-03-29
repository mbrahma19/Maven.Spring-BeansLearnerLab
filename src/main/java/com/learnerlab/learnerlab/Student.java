package com.learnerlab.learnerlab;

import javax.persistence.Entity;

@Entity
public class Student extends Person implements Learner{

    private Double totalStudyTime;

    public Student(Long id, String name) {
        super(id, name);
    }

    public Double getTotalStudyTime() {
        return totalStudyTime;
    }

    @Override
    public void learn(double numberOfHours) {
        totalStudyTime += numberOfHours;
    }
}
