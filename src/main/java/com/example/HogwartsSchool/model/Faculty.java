package com.example.HogwartsSchool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Collection;

@Entity
public class Faculty {
    @Id
    @GeneratedValue
    private Long ID;
    private String name;
    private String feature;
    private String color;

    @OneToMany(mappedBy = "faculty")
    private Collection<Student> students;

    public Faculty(Long ID, String name, String feature, String color) {
        this.ID = ID;
        this.name = name;
        this.feature = feature;
        this.color = color;
    }

    public Faculty() {
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "ID=" + ID +
                ", название='" + name + '\'' +
                ", Особенность='" + feature + '\'' +
                ", цвет='" + color + '\'' +
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

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
