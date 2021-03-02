package pl.tomozak.learningAmigoscode.student;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @Transient
    private Integer age;
    private LocalDate dob;
    private String email;

    public Student(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }


    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
