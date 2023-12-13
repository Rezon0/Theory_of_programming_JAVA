package org.example;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;
    private String name;
    private Date dateOfBirth;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Allergy> allergies = new HashSet<>();

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private VaccinationCertificate vaccinationCertificate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Allergy> getAllergies() {
        return allergies;
    }

    public void setAllergies(Set<Allergy> allergies) {
        this.allergies = allergies;
    }

    public VaccinationCertificate getVaccinationCertificate() {
        return vaccinationCertificate;
    }

    public void setVaccinationCertificate(VaccinationCertificate vaccinationCertificate) {
        this.vaccinationCertificate = vaccinationCertificate;
    }


    public String toString() {
        return "Последняя сделанная прививка у школьника " + lastName + " " + name + " " + dateOfBirth + " " + vaccinationCertificate.getId()
                + " была: ";
    }
}
