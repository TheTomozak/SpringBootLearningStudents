package pl.tomozak.learningAmigoscode.student;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private Long id;
    private String name;
    private Integer age;
    private LocalDate dob;
    private String email;



}
