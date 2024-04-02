package com.Spring.boot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {

    @Transactional(readOnly = true)
    @Query(value = "Select * from Student a where a.age>= :age",
            nativeQuery = true)
    List<Student> findAllByage(@Param("age") int age);

    @Transactional(readOnly = true)
    @Query(value = "Select * from Student a where a.firstname like CONCAT('%',:name,'%') ",
            nativeQuery = true)
    List<Student> findAllByFname(@Param("name") String name);
}
