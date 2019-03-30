package com.learnerlab.learnerlab;

public class Instructor extends Person implements Teacher {

    private Double numbersOfHoursTaught;

    public Instructor(Long id, String name) {
        super(id, name);
        numbersOfHoursTaught = 0.0;
    }

    public Double getNumbersOfHoursTaught() {
        return numbersOfHoursTaught;
    }

    public void setNumbersOfHoursTaught(Double numbersOfHoursTaught) {
        this.numbersOfHoursTaught = numbersOfHoursTaught;
    }

    public void updateHoursTaught(Double numbersOfHoursTaught){
        this.numbersOfHoursTaught += numbersOfHoursTaught;
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
