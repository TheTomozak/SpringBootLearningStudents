package pl.tomozak.learningAmigoscode.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tomozak.learningAmigoscode.models.Student;
import pl.tomozak.learningAmigoscode.models.Subject;
import pl.tomozak.learningAmigoscode.student.StudentRepository;
import pl.tomozak.learningAmigoscode.subject.exceptions.SubjectAlreadyExistsException;

import java.util.List;
import java.util.Optional;

@Service
class SubjectService {

    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository,StudentRepository studentRepository ) {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public List<Subject> getListOfSubject() {
        return subjectRepository.findAll();
    }

    public Subject addNewSubject(Subject subject) {
        Optional<Subject> subjectOptional = subjectRepository.findByName(subject.getName());

        if (subjectOptional.isPresent()) {
            throw new SubjectAlreadyExistsException();
        }

        return subjectRepository.save(subject);

    }

    public Subject enrollStudentToSubject(Long subjectId, Long studentId){

        Subject subject = subjectRepository.getOne(subjectId);
        Student student= studentRepository.getOne(studentId);
        subject.getEnrolledStudents().add(student);

        return subjectRepository.save(subject);

    }

}
