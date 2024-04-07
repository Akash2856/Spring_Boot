package com.Spring.boot;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private SchoolMapper schoolMapper;
    private SchoolRepository schoolRepository;

    public SchoolService(SchoolMapper schoolMapper, SchoolRepository schoolRepository) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }

    public SchoolDTO post(SchoolDTO schoolDTO){
        var school = schoolMapper.toSchool(schoolDTO);
        schoolRepository.save(school);
        return schoolDTO;
    }
    public School create(School school){
        return schoolRepository.save(school);
    }
    public List<SchoolDTO> findAllSchool(){
        return schoolRepository.findAll().stream().map(schoolMapper::toSchoolDTO).collect(Collectors.toList());
    }
    public List<School> findAll(){
        return  schoolRepository.findAll();
    }
}
