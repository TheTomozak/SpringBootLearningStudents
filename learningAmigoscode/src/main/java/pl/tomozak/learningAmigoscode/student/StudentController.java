package pl.tomozak.learningAmigoscode.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
class StudentController {

    private final StudentService studentService;//autowired w automagiczny sposób tworzy dla nas instacje studetnService i wstrzykuje do kontorolera

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK, reason = "Student added")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
}
