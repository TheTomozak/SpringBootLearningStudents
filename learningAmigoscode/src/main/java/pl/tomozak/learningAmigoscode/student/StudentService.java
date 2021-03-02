package pl.tomozak.learningAmigoscode.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }

        if(!student.getEmail().contains("@")){
            throw new IllegalStateException("Incorrect email");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if(!exists){
            throw new IllegalStateException("Student with id "+ studentId+" not exists");
        }

        studentRepository.deleteById(studentId);
    }


    @Transactional
    public void updateStudent( Long studentId, String name, String email) {

        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student with id:"+studentId+ " not exists"));

        if(name == null ||name.length() <= 0){
            throw new IllegalStateException("Name is required");
        }else {
            student.setName(name);
        }

        if(email == null || email.length() <= 0){
            throw new IllegalStateException("Email is required");
        }else if (studentRepository.findStudentByEmail(email).isPresent()){
            throw new IllegalStateException("Email is taken");
        }
        else {
            student.setEmail(email);
        }

    }
}
