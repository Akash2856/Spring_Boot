package com.Spring.boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolControler {

    private final SchoolRepository schoolRepository;

    public SchoolControler(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }
//-----------------------------------------------------------------------------
    @PostMapping("/schools")
    public School create(
            @RequestBody School school
    ){
        return schoolRepository.save(school);
    }

    @GetMapping("/schools")
    public List<School> findAll(){
        return  schoolRepository.findAll();
    }

    //---------------------------------------------------------------------------

    @GetMapping("/listOnlySchool")
    public List<SchoolDTO> findAllSchool(){
        return schoolRepository.findAll().stream().map(this::toSchoolDTO).collect(Collectors.toList());
    }
    private SchoolDTO toSchoolDTO(School school){
        return new SchoolDTO(school.getName());//we are fetching the data so getName()
    }

//--------------------------------------------------------------------------------
//  previous output
//    {
//        "id": 2,
//            "name": "SVM Noida",
//            "students": null
//    }


    @PostMapping("/onlySchool")
    public SchoolDTO post(
            @RequestBody SchoolDTO schoolDTO
    ){
        var school = toSchool(schoolDTO);
        schoolRepository.save(school);
        return schoolDTO;
    }
    public School toSchool(SchoolDTO dto){
        return new School(dto.name());
    }
}
