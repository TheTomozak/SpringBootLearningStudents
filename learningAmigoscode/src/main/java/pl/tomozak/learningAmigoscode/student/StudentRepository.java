package pl.tomozak.learningAmigoscode.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tomozak.learningAmigoscode.models.Student;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    Optional<Student> findStudentByEmail(String email);

}
