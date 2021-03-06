package pl.tomozak.learningAmigoscode.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.tomozak.learningAmigoscode.models.Student;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
@Validated
class StudentController {

    private final StudentService studentService;//autowired w automagiczny sposób tworzy dla nas instacje studetnService i wstrzykuje do kontorolera

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK, reason = "Student added")
    public void registerNewStudent(@Validated @RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping("{studentId}")
    @ResponseStatus(value = HttpStatus.OK, reason = "Student deleted")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping("{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}
