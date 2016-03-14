package io.khasang.enterprise.model;

import java.util.ArrayList;
import java.util.List;

public class Employee extends User {
    private int salary;
    private List<String> experience = new ArrayList<String>();

    public void addExperience(String companeName){
        experience.add(companeName);
    }

    public List<String> getExperience() {
        return experience;
    }

}
