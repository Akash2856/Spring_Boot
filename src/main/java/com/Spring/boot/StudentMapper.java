package com.Spring.boot;

import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto){
        var student= new Student();
        student.setFirstname(dto.firstname());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);
        return student;
    }

    public StudentresponseDto tostudentresponseDto(Student student){
        return new StudentresponseDto(student.getFirstname(),student.getLastName(),student.getEmail());
    }
}
