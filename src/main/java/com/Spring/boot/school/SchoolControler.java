package com.Spring.boot.school;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolControler {

    private SchoolService schoolService;

    public SchoolControler(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    //-----------------------------------------------------------------------------
    @PostMapping("/schools")
    public School create(
            @RequestBody School school
    ){
        return schoolService.create(school);
    }

    @GetMapping("/schools")
    public List<School> findAll(){
        return  schoolService.findAll();
    }

    //---------------------------------------------------------------------------

    @GetMapping("/listOnlySchool")
    public List<SchoolDTO> findAllSchool(){
        return schoolService.findAllSchool();
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
        return schoolService.post(schoolDTO);
    }
}
