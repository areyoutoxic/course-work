package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Класс-запуск проекта
 */
@SpringBootApplication
public class DemoApplication {

    /**
     * Запуск приложения
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

