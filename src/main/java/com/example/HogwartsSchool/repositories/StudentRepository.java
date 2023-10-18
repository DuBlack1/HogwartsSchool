package com.example.HogwartsSchool.repositories;

import com.example.HogwartsSchool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;


public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAge(int age);

    Collection<Student> findByCourse(int course);

    Collection<Student> findStudentsByFaculty_ID(long facultyId);
}
