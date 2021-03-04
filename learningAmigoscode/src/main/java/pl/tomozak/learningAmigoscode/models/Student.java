package pl.tomozak.learningAmigoscode.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @JsonBackReference
    @ManyToMany(mappedBy = "enrolledStudents")
    @JsonIgnoreProperties("enrolledStudents")
    private Set<Subject> subjects = new HashSet<>();

    @Column(nullable = false, length = 64)
    private String name;

    @Transient
    private Integer age;

    private LocalDate dob;

    @Column(nullable = false, length = 128, unique = true)
    private String email;


    public Student(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Student() {
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
