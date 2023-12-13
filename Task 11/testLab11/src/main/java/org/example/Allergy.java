package org.example;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Allergy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String allergyName;
    private int ageOfOnset;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAllergyName() {
        return allergyName;
    }

    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }

    public int getAgeOfOnset() {
        return ageOfOnset;
    }

    public void setAgeOfOnset(int ageOfOnset) {
        this.ageOfOnset = ageOfOnset;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}


