package io.khasang.enterprise.model.newmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class News {

    @Id
    @GeneratedValue
    private int id;
}