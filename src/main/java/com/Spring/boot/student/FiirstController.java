package com.Spring.boot.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class FiirstController {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello Akash padai chal rhi hai!!!!";
    }

    private final StudentService studentService;

    public FiirstController(StudentService studentService) {
        this.studentService = studentService;
    }

    //save method is related to studentRepo and it's return same object
//    @PostMapping("/students")
//    public Student post(
//            @RequestBody Student student){
//        return studentRepo.save(student);
//    }
   @GetMapping("/students")
   public List<StudentresponseDto> findAllStudent(){
        return studentService.findAllStudent();
   }
   @GetMapping("/students/{age}")
    public List<Student> findAllByage(
            @PathVariable("age") Integer age
   ){
        return studentService.findAllByage(age);
   }

   @GetMapping("students/{name}")
    public List<StudentresponseDto>findAllByFname(
            @PathVariable("name") String name
   ){
        return studentService.findAllByFname(name);
   }

   @DeleteMapping("/students/{student-id}")
   @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
   ){
        studentService.delete(id);
   }
   //http://localhost:8080/students/akash?id=52 for update
   @PutMapping("/students/{fname}")
    public void updateStudentName(
            @PathVariable("fname") String fname,
            @RequestParam("id") Integer id
            ){
        studentService.updateStudentName(fname,id);
   }

//    {
//    "firstname":"vishal",
//    "lastName":"yadav",
//    "email":"vishal@asd.com",
//    "schoolId":1
//        "lastName": "yadav",
//        "email": "vishal@asd.com"
//}
//    http://localhost:8080/students
    @PostMapping("/students")
    public StudentresponseDto post(
            @Valid @RequestBody StudentDto studentDto
    ){
         return studentService.post(studentDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>handelMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<String,String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error ->{
                    var fieldName = ((FieldError) error).getField();
                    var errormessage = error.getDefaultMessage();
                    errors.put(fieldName,errormessage);
                });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}