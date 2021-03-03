package pl.tomozak.learningAmigoscode.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class StudentServiceIntegrationTest {

    @Autowired
    private StudentService service;

    @MockBean
    private StudentRepository repository;


    @Test
    public void getStudents_TwoObject_returnTwoObject() {
        when(repository.findAll()).
                thenReturn(Stream
                        .of(Student.builder().name("Tomek").dob(LocalDate.ofYearDay(1999, 5)).email("Tomek@wp.pl").build(),
                                (Student.builder().name("Tomek").dob(LocalDate.ofYearDay(1999, 5)).email("Tomek@wp.pl").build()))
                        .collect(Collectors.toList()));

        assertEquals(2, service.getStudents().size());
        assertNotNull(service.getStudents());
    }

    @Test
    public void registerNewStudent_invalidEmail_throwsIllegalStateException(){
        Student student = Student.builder().name("Tomek").dob(LocalDate.ofYearDay(1999, 5)).email("Tomekwp.pl").build();

        when(repository.save(student)).thenReturn(student);
        assertThrows(IllegalStateException.class,()-> service.addNewStudent(student));

    }

    @Test
    public void registerNewStudent_AllParamsOk_ReturnNewStudent(){
        Student student = Student.builder().name("Tomek").dob(LocalDate.ofYearDay(1999, 5)).email("Tomek@wp.pl").build();

        when(repository.save(student)).thenReturn(student);
        assertEquals(student, service.addNewStudent(student));

    }

    @Test
    public void registerNewStudent_CheckDate_ReturnNewStudent(){
        Student student = Student.builder().name("Tomek").dob(LocalDate.ofYearDay(1999, 5)).email("Tomek@wp.pl").build();

        when(repository.save(student)).thenReturn(student);
        assertEquals(22, service.addNewStudent(student).getAge());

    }

}