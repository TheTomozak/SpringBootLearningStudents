package pl.tomozak.learningAmigoscode.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;


    //    @JsonManagedReference
    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToMany
    @JsonIgnoreProperties("subjects")
    @JoinTable(
            name = "student_enrolled",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )

    private Set<Student> enrolledStudents = new HashSet<>();

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("subjects")
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;


    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Set<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
