package com.example.HogwartsSchool.service;

import com.example.HogwartsSchool.model.Faculty;
import com.example.HogwartsSchool.repositories.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FacultyService {
    private FacultyRepository facultyRepository;


    public Faculty getFaculty(Long ID) {
        return facultyRepository.findById(ID).get();
    }

    public Collection<Faculty> getAllSFaculty() {
        return facultyRepository.findAll();
    }

    public Collection<Faculty> findFacultyByColor(String color) {
        return facultyRepository.findByColor(color);
    }

    public Faculty findByStudents_id(Long idStudent) {
        return facultyRepository.findByStudents_ID(idStudent);
    }
}
