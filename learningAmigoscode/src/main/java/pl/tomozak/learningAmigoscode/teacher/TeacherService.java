package pl.tomozak.learningAmigoscode.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tomozak.learningAmigoscode.exceptions.IdNotExistsException;
import pl.tomozak.learningAmigoscode.exceptions.teacher.TeacherExistsException;
import pl.tomozak.learningAmigoscode.models.Subject;
import pl.tomozak.learningAmigoscode.models.Teacher;
import pl.tomozak.learningAmigoscode.subject.SubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
class TeacherService {

    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<Teacher> getTeacherList() {
        return teacherRepository.findAll();

    }

    public Teacher addTeacher(Teacher teacher) {
        Optional<Teacher> optionalTeacher = teacherRepository.findByNameAndLastName(teacher.getName(), teacher.getLastName());

        if (optionalTeacher.isPresent()) {
            throw new TeacherExistsException();
        }

        return teacherRepository.save(teacher);
    }

    public Teacher enrollStudentToSubject(Long subjectId, Long teacherId) {

        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        Optional<Subject> subject = subjectRepository.findById(subjectId);

        if(teacher.isEmpty() || subject.isEmpty()){
            throw new IdNotExistsException();
        }

        subject.get().assignTeacher(teacher.get());

        return teacherRepository.save(teacher.get());

    }
}
