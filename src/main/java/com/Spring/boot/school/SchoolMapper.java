package com.Spring.boot.school;

import com.Spring.boot.school.SchoolDTO;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper{


    public SchoolDTO toSchoolDTO(School school){
        return new SchoolDTO(school.getName());//we are fetching the data so getName()
    }


    public School toSchool(SchoolDTO dto){
        return new School(dto.name());
    }
}
