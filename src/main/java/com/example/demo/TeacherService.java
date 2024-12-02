package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс сервис преподавателя
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherRepository repo;

    /**
     * Получить список преподавателей либо полный, либо с отбором по ключевому слову
     *
     * @param keyword ключевое слово для отбора
     * @return список преподавателей
     */
    public List<Teacher> getAllTeachers(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    /**
     * Сохранить преподавателя
     *
     * @param teacher преподаватель
     */
    public void saveTeacher(Teacher teacher) {
        repo.save(teacher);
    }

    /**
     * Получить преподавателя
     *
     * @param id id преподавателя
     * @return преподаватель
     */
    public Teacher getTeacher(Integer id) {
        return repo.findById(id).get();
    }

    /**
     * Удалить преподавателя
     *
     * @param id id преподавателя
     */
    public void deleteTeacher(Integer id) {
        repo.deleteById(id);
    }
}
