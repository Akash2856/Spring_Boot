package com.Spring.boot.studentProfile;

import com.Spring.boot.student.Student;
import jakarta.persistence.*;

@Entity
public class StudentProfile  {
    @Id
    @GeneratedValue
    private Integer id;
    private String bio;

    public Integer getId() {
        return id;
    }
    @OneToOne
    @JoinColumn(name = "")
    private Student student;

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentProfile() {
    }

    public StudentProfile(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
