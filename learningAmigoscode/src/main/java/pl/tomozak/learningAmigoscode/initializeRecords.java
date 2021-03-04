package pl.tomozak.learningAmigoscode;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.tomozak.learningAmigoscode.models.Student;
import pl.tomozak.learningAmigoscode.models.Subject;
import pl.tomozak.learningAmigoscode.student.StudentRepository;
import pl.tomozak.learningAmigoscode.subject.SubjectRepository;
import pl.tomozak.learningAmigoscode.models.Teacher;
import pl.tomozak.learningAmigoscode.teacher.TeacherRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
class initializeRecords {

    @Bean
    CommandLineRunner commandLineRunner(SubjectRepository subjectRepository,
                                        StudentRepository studentRepository,
                                        TeacherRepository teacherRepository) {

        return args -> {
            Subject matematyka = new Subject("Matematyka");
            Subject informatyka =new Subject("Informatyka");


            Student tomek = new Student("Tomek",LocalDate.of(2000, Month.FEBRUARY, 5), "xxx@gmail.com" );
            Student jan = new Student("Jan",LocalDate.of(2202, Month.APRIL, 10), "yyy@gmail.com" );

            Teacher jacekKowalski = new Teacher("Jacek", "Kowalski");
            Teacher miroslawGlosnicki = new Teacher("Mirosław", "Głośnicki");

            subjectRepository.saveAll(List.of(matematyka, informatyka));
            studentRepository.saveAll(List.of(tomek, jan));
            teacherRepository.saveAll(List.of(jacekKowalski, miroslawGlosnicki));
        };

    }
}