package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Интерфейс репозиторий студента
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT p FROM Student p WHERE CONCAT(p.ID, p.firstName, p.lastName, p.groupNumber, p.email) LIKE %?1%")
    List<Student> search(String keyword);
}
