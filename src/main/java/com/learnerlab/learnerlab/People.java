package com.learnerlab.learnerlab;

import java.util.Iterator;
import java.util.List;

public class People<PersonType extends Person> implements Iterable<PersonType>{

    private List<PersonType> list;

    public People(List<PersonType> list){
        this.list = list;
    }

    public void add(PersonType personType){
        list.add(personType);
    }

    public void remove(PersonType personType){
        list.remove(personType);
    }

    public Integer size(){
        return list.size();
    }

    public void clear(){
        list.clear();
    }

    public PersonType findById(Long id){
        PersonType personType = null;
        for(PersonType pt: list){
            if(pt.getId().equals(id)){
                personType = pt;
            }
        }
        return personType;
    }

    public List<PersonType> findAll(){
        return this.list;
    }

    public void addAll(Iterable<PersonType> iterable){
        iterable.forEach(i -> list.add(i));
    }

    @Override
    public Iterator<PersonType> iterator() {
        return list.iterator();
    }

}
