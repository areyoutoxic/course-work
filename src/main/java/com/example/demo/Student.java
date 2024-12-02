package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Класс студент
 */
@Entity
@Data
public class Student {
    private Integer ID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String GroupNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getID() {
        return ID;
    }
}





