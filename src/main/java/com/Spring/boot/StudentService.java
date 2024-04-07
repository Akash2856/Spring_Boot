package com.Spring.boot;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private StudentRepo studentRepo;
    private StudentMapper studentMapper;

    public StudentService(StudentRepo studentRepo, StudentMapper studentMapper) {
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
    }

    public StudentresponseDto post(StudentDto studentDto){
        var student =studentMapper.toStudent(studentDto);
        return studentMapper.tostudentresponseDto(studentRepo.save(student));
    }

    public void updateStudentName(String name, Integer Id){
        studentRepo.updateStudentName(name,Id);
    }
    public void delete(Integer id){
        studentRepo.deleteById(id);
    }

    public List<StudentresponseDto> findAllStudent(){

        return studentRepo.findAll().stream().map(studentMapper::tostudentresponseDto).collect(Collectors.toList());
    }

    public List<StudentresponseDto>findAllByFname(String name){
        return studentRepo.findAllByFname(name).stream().map(studentMapper::tostudentresponseDto).collect(Collectors.toList());
    }
    public List<Student> findAllByage(Integer age){
        return studentRepo.findAllByage(age);
    }
}
