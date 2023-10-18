package com.example.HogwartsSchool.service;

import com.example.HogwartsSchool.model.Student;
import com.example.HogwartsSchool.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getStudent(Long ID){
        return studentRepository.findById(ID).get();
    }

    public Collection<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student deleteStudent(Long ID){
        if (studentRepository.findById(ID).isPresent()){
            Student student = studentRepository.findById(ID).get();
            studentRepository.deleteById(ID);
            return student;
        }
        return null;
    }

    public Collection<Student> findStudentsByAge(int age) {
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findStudentByCourse(int course){
        return studentRepository.findByCourse(course);
    }

    public Collection<Student> findStudentsByFaculty_id(long faculty_id){
        return studentRepository.findStudentsByFaculty_ID(faculty_id);
    }
}
