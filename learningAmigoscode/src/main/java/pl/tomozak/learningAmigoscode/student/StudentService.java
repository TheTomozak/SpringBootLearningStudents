package pl.tomozak.learningAmigoscode.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
class StudentService {

    public List<Student> getStudents(){
        Student student1 = Student.builder()
                .id(1L)
                .age(22)
                .name("Tomek")
                .dob(LocalDate.of(2000, Month.APRIL, 5))
                .email("xxx@gmail.com")
                .build();

        Student student2 = Student.builder()
                .id(2L)
                .age(52)
                .name("Jan")
                .dob(LocalDate.of(2202, Month.APRIL, 10))
                .email("yyy@gmail.com")
                .build();

        return List.of(student1,student2 );

    }
}
