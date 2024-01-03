package com.mycompany.api.controller;

import com.mycompany.api.models.Student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentApiController {

    private static final List<Student> listStudents = new ArrayList<>();
    public static Integer studentID = 0;

    static{
        listStudents.add(new Student(++studentID,"Mohammad"));
        listStudents.add(new Student(++studentID,"Hossein"));
        listStudents.add(new Student(++studentID,"Hamed"));
    }

    @GetMapping
    public ResponseEntity<?> getAllStudents(){
        if(listStudents.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(listStudents, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        student.setId(++studentID);
        listStudents.add(student);
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> replace(@RequestBody Student student){
        if (listStudents.contains(student)){
            int index = listStudents.indexOf(student); // get we index of this object
            listStudents.set(index,student);
            return new ResponseEntity<>(student,HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        Student student = new Student(id); // Because the hash and equality methods are set with ID, then whether an object is in the list of students or not is only possible with ID.
        if(listStudents.contains(student)){
            listStudents.remove(student);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
