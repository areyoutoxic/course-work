package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Класс преподаватель
 */
@Entity
@Data
public class Teacher {
    private Integer ID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Discipline;
    private String GroupNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getID() {
        return ID;
    }
}
