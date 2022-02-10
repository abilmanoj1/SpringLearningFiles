package com.dexlock.SpringRestDemo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;

@Service
public class StudentService {
    public Student getStudent(){
        return new Student(
                1L,
                "Abil Manoj",
                "abilmanoj1@gmail.com",
                LocalDate.of(2000, Month.DECEMBER,25),
                25
        );
    }
}
