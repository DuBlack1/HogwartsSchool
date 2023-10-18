package com.example.HogwartsSchool.repositories;

import com.example.HogwartsSchool.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findByColor(String color);

    Faculty findByStudents_ID(Long idStudent);
}
