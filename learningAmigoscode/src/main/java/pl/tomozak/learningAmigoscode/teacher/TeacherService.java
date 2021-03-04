package pl.tomozak.learningAmigoscode.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tomozak.learningAmigoscode.exceptions.teacher.TeacherExistsException;
import pl.tomozak.learningAmigoscode.models.Teacher;

import java.util.List;
import java.util.Optional;

@Service
class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeacherList(){
        return teacherRepository.findAll();

    }

    public Teacher addTeacher (Teacher teacher){
        Optional<Teacher> optionalTeacher = teacherRepository.findByNameAndLastName(teacher.getName(), teacher.getLastName());

        if(optionalTeacher.isPresent()){
            throw new TeacherExistsException();
        }

        return teacherRepository.save(teacher);
    }

}
