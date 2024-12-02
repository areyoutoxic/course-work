package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Класс сервис студента
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;

    /**
     * Получить список студентов либо полный, либо с отбором по ключевому слову
     *
     * @param keyword ключевое слово для отбора
     * @return список студентов
     */
    public List<Student> getAllStudents(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    /**
     * Сохранить студента
     *
     * @param student преподаватель
     */
    public void saveStudent(Student student) {
        repo.save(student);
    }

    /**
     * Получить студента
     *
     * @param id id студента
     * @return студент
     */
    public Student getStudent(Integer id) {
        return repo.findById(id).get();
    }

    /**
     * Удалить студента
     *
     * @param id id студента
     */
    public void deleteStudent(Integer id) {
         repo.deleteById(id);
    }


}
