package com.learnerlab.learnerlab;

public class Instructor extends Person implements Teacher {

    public Instructor(Long id, String name) {
        super(id, name);
    }

    @Override
    public void teach(Learner learner, double numberOfHours) {
        learner.learn(numberOfHours);
    }

    @Override
    public void lecture(Iterable<? extends Learner> learners, double numberOfHours) {
        double numberOfHoursPerLearner = numberOfHours/getSize(learners);
        learners.forEach(l -> teach(l, numberOfHoursPerLearner));
    }

    public Integer getSize(Iterable<? extends Learner> iterable){
        Integer counter = 0;
        for(Learner l : iterable){ counter++; }
        return counter;
    }
}
