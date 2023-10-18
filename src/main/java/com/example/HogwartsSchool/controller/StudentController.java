package com.example.HogwartsSchool.controller;

import com.example.HogwartsSchool.model.Student;
import com.example.HogwartsSchool.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("student")
@Tag(name = "Работа со студентами")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Дорбавление студентов")
    @PostMapping
    public ResponseEntity createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @Operation(summary = "Поиск студентов по ID")
    @GetMapping("{ID}")
    public ResponseEntity getStudent(@PathVariable Long ID) {
        Student student = studentService.getStudent(ID);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @Operation(summary = "Вывод всех студентов")
    @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @Operation(summary = "Удаление студентов по ID")
    @DeleteMapping("{ID}")
    public ResponseEntity deleteStudent(@PathVariable Long ID) {
        Student deleteStudent = studentService.deleteStudent(ID);
        return ResponseEntity.ok(deleteStudent);
    }

    @Operation(summary = "Поиск студентов по возрасту")
    @GetMapping("{age}")
    public ResponseEntity<Collection<Student>> findStudentSByAge(@PathVariable int age) {
        Collection<Student> findStudents = studentService.findStudentsByAge(age);
        if (findStudents == null) {
            ResponseEntity.notFound().build();;
        }
        return ResponseEntity.ok(findStudents);
    }

    @Operation(summary = "Поиск студентов по курсу")
    @GetMapping("{course}")
    public ResponseEntity<Collection<Student>> findStudentByCourse(@PathVariable int course) {
        Collection<Student> findStudents = studentService.findStudentByCourse(course);
        if (findStudents == null) {
            ResponseEntity.notFound().build();;
        }
        return ResponseEntity.ok(findStudents);
    }

    @Operation(summary = "Поиск студентов по ID факультетов")
    @GetMapping("/findByFaculty_id")
    public ResponseEntity<Collection<Student>> findStudentsByFaculty_id(@RequestParam long faculty_id){
        Collection<Student> findStudents = studentService.findStudentsByFaculty_id(faculty_id);
        if (findStudents == null) {
            ResponseEntity.notFound().build();;
        }
        return ResponseEntity.ok(findStudents);
    }
}
