package com.java.firebase.studentsPackage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsController {
    public StudentsService studentsService;

    public StudentsController(StudentsService studentsService){
        this.studentsService = studentsService;
    }

    @GetMapping("/getStudent")
    public Students getStudent(@RequestParam String studentID) throws Exception{
        return studentsService.getStudent(studentID);
    }

    @GetMapping("/getAllStudents")
    public List<Students> getAllStudents() throws Exception {
        return studentsService.getAllStudents();
    }



    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody Students students) throws Exception{
        return studentsService.updateStudent(students);
    }

    @PutMapping("/deleteStudent")
    public String deleteStudent(@RequestParam String studentID) throws Exception{
        return studentsService.deleteStudent(studentID);
    }

    @GetMapping("/testStudent")
    public ResponseEntity<String> testGetEndPoint(){
        return ResponseEntity.ok("Test get endpoint is working");
    }
}
