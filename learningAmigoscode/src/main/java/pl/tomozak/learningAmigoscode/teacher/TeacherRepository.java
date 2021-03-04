package pl.tomozak.learningAmigoscode.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tomozak.learningAmigoscode.models.Teacher;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByNameAndLastName (String name, String lastName);
}
