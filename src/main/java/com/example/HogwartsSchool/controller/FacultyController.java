package com.example.HogwartsSchool.controller;

import com.example.HogwartsSchool.model.Faculty;
import com.example.HogwartsSchool.service.FacultyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
@Tag(name = "Работа с факультетами")
public class FacultyController {
    private final FacultyService facultyService;
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @Operation(summary = "Поиск факультетов по ID")
    @GetMapping("{ID}")
    public ResponseEntity getFaculty(@PathVariable Long ID) {
        Faculty faculty = facultyService.getFaculty(ID);
        if(faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @Operation(summary = "Вывод всех факультетов")
    @GetMapping
    public ResponseEntity<Collection<Faculty>> getAllFaculty() {
        return ResponseEntity.ok(facultyService.getAllSFaculty());
    }

    @Operation(summary = "Поиск факультетов по цвету герба")
    @GetMapping("{color}")
    public ResponseEntity<Collection<Faculty>> findFacultySByColor(@PathVariable String color) {
        Collection<Faculty> findFaculty = facultyService.findFacultyByColor(color);
        if (findFaculty == null) {
            ResponseEntity.notFound().build();;
        }
        return ResponseEntity.ok(findFaculty);
    }

    @Operation(summary = "Поиск факультетов по ID студента")
    @GetMapping("/student")
    public ResponseEntity findByNameOrColor(@RequestParam Long idStudent) {
        Faculty findFaculty = facultyService.findByStudents_id(idStudent);
        if (findFaculty == null) {
            ResponseEntity.notFound().build();;
        }
        return ResponseEntity.ok(findFaculty);
    }
}
