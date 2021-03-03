package pl.tomozak.learningAmigoscode.student;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class StudentTest {

    @Test
    void getAge_dataOkAgeOk_resultTrue(){

        //given
        Student student = new Student("Tomek", LocalDate.ofYearDay(1999, 3), "xxx@wp.pl");
        //when
        //then
        assertEquals(22, student.getAge());
    }
}
