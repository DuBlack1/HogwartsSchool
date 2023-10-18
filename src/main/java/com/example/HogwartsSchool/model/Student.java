package com.example.HogwartsSchool.model;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long ID;
    private String name;
    private String surname;
    private int age;
    private int course;
    @ManyToOne
    @JoinColumn (name = "faculty_ID")
    private Faculty faculty;


    public Student(Long ID, String name, String surname, int age, int course) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.course = course;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", имя='" + name + '\'' +
                ", фамилия='" + surname + '\'' +
                ", возраст=" + age +
                ", курс=" + course +
                '}';
    }

    public Long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age >= 11){
            this.age = age;
        }else {
            System.out.println("Ошибка ввода возраста");
        }
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
