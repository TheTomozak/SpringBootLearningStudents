package pl.tomozak.learningAmigoscode.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tomozak.learningAmigoscode.models.Subject;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Optional<Subject> findByName(String name);
}
