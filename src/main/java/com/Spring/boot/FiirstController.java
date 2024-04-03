package com.Spring.boot;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FiirstController {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello Akash padai chal rhi hai!!!!";
    }
    private final StudentRepo studentRepo;

    public FiirstController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    //save method is related to studentRepo and it's return same object
    @PostMapping("/students")
    public Student post(
            @RequestBody Student student){
        return studentRepo.save(student);
    }
   @GetMapping("/students")
   public List<Student> findAllStudent(){
        return studentRepo.findAll();
   }
   @GetMapping("/students/{age}")
    public List<Student> findAllByage(
            @PathVariable("age") Integer age
   ){
        return studentRepo.findAllByage(age);
   }

   @GetMapping("students/{name}")
    public List<Student>findAllByFname(
            @PathVariable("name") String name
   ){
        return studentRepo.findAllByFname(name);
   }

   @DeleteMapping("/students/{student-id}")
   @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
   ){
        studentRepo.deleteById(id);
   }
   //http://localhost:8080/students/akash?id=52 for update
   @PutMapping("/students/{fname}")
    public void updateStudentName(
            @PathVariable("fname") String fname,
            @RequestParam("id") Integer id
            ){
        studentRepo.updateStudentName(fname,id);
   }
}