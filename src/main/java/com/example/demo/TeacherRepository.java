package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Интерфейс репозиторий преподавателя
 */
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query("SELECT p FROM Teacher p WHERE CONCAT(p.ID, p.firstName, p.lastName, p.discipline, p.groupNumber, p.email) LIKE %?1%")
    List<Teacher> search(String keyword);
}
