package com.example.demo;

import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Класс контроллер проекта
 */
@org.springframework.stereotype.Controller
public class AppController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

  /**
     * Вернуть начальную страницу
     *
     * @return начальная страница
     */
    @GetMapping("/")
    public String index() {
        return "homePage";
    }

    /**
     * Вернуть страницу со студентами с отбором по ключевому слову
     * Если ключевое слово не задано, вернуть всех студентов
     *
     * @param model модель
     * @param keyword ключевое слово
     * @return страница со студентами
     */
    @GetMapping("/Student")
    public String openStudent(Model model, @Param("keyword") String keyword) {
        List<Student> studentList = studentService.getAllStudents(keyword);
        model.addAttribute("studentList", studentList);
        model.addAttribute("keyword", keyword);
        return "student";
    }

    /**
     * Вернуть страницу с преподавателями с отбором по ключевому слову
     * Если ключевое слово не задано, вернуть всех преподавателей
     *
     * @param model модель
     * @param keyword ключевое слово
     * @return страница с преподавателями
     */
    @GetMapping("/Teacher")
    public String openTeacher(Model model, @Param("keyword") String keyword) {
        List<Teacher> teacherList = teacherService.getAllTeachers(keyword);
        model.addAttribute("teacherList", teacherList);
        model.addAttribute("keyword", keyword);
        return "teacher";
    }

    /**
     * Вернуть страницу с информацией об авторе проекта
     *
     * @return страница с информацией об авторе проекта
     */
    @GetMapping("/AboutMe")
    public String openAboutMe() {
        return "aboutMe";
    }

    /**
     * Вернуть страницу создания нового студента
     *
     * @param model модель
     * @return страница создания нового студента
     */
    @RequestMapping("/newStudent")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "newStudent";
    }

    /**
     * Вернуть страницу создания нового преподавателя
     *
     * @param model модель
     * @return страница создания нового преподавателя
     */
    @RequestMapping("/newTeacher")
    public String newTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "newTeacher";
    }

    /**
     * Сохранить студента, вернуть обновленную страницу со студентами
     *
     * @param student студент
     * @return обновленная страница со студентами
     */
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:Student";
    }

    /**
     * Сохранить преподавателя, вернуть обновленную страницу с преподавателями
     *
     * @param teacher преподаватель
     * @return обновленная страница с преподавателями
     */
    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:Teacher";
    }

    /**
     * Вернуть страницу редактирования студента
     *
     * @param id идентификатор студента
     * @return страница редактирования студента с существующими данными
     */
    @GetMapping("/editStudent/{id}")
    public ModelAndView editStudent(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("editStudent");
        Student student = studentService.getStudent(id);
        mav.addObject("student", student);
        return mav;
    }

    /**
     * Вернуть страницу редактирования преподавателя
     *
     * @param id идентификатор преподавателя
     * @return страница редактирования преподавателя с существующими данными
     */
    @GetMapping("/editTeacher/{id}")
    public ModelAndView editTeacher(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("editTeacher");
        Teacher teacher = teacherService.getTeacher(id);
        mav.addObject("teacher", teacher);
        return mav;
    }

    /**
     * Удалить студента, обновить страницу со студентами
     *
     * @param id идентификатор студента
     * @return обновленная страница со студентами
     */
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "redirect:http://localhost:8081/Student";
    }

    /**
     * Удалить преподавателя, обновить страницу с преподавателями
     *
     * @param id идентификатор преподавателя
     * @return обновленная страница с преподавателями
     */
    @GetMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return "redirect:http://localhost:8081/Teacher";
    }
}
