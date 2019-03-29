package com.learnerlab.learnerlab;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InstructorsConfig {

    @Bean(name = "usInstructors")
    public Instructors tcUsaInstructors(){
        List<Instructor> list = new ArrayList<>();
        list.add(new Instructor(23l, "Nhu"));
        list.add(new Instructor(24l, "Wilhelm"));
        list.add(new Instructor(25l, "Kris"));
        return new Instructors(list);
    }

    @Bean(name = "ukInstructors")
    public Instructors tcUKInstructors(){
        List<Instructor> list = new ArrayList<>();
        list.add(new Instructor(20l, "Dolio"));
        list.add(new Instructor(21l, "Leon"));
        list.add(new Instructor(22l, "Froilan"));
        return new Instructors(list);
    }

    @Primary
    @Bean(name = "instructors")
    public Instructors instructors(){
        List<Instructor> newList = tcUsaInstructors().findAll();
        newList.addAll(tcUKInstructors().findAll());
        return new Instructors(newList);

//        List<Instructor> list = Stream.concat(tcUKInstructors().findAll().stream(),
//                tcUsaInstructors().findAll().stream()).
//                collect(Collectors.toCollection(ArrayList::new));
//
//        return new Instructors(list);
    }
}
