package pl.tomozak.learningAmigoscode.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.tomozak.learningAmigoscode.models.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository){

        return args -> {
            Student tomek = Student.builder()
                    .name("Tomek")
                    .dob(LocalDate.of(2000, Month.FEBRUARY, 5))
                    .email("xxx@gmail.com")
                    .build();

            Student jan = Student.builder()
                    .name("Jan")
                    .dob(LocalDate.of(2202, Month.APRIL, 10))
                    .email("yyy@gmail.com")
                    .build();

            repository.saveAll(List.of(tomek,jan));
        };

    }
}
