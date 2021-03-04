package pl.tomozak.learningAmigoscode.teacher;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.tomozak.learningAmigoscode.models.Teacher;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/teacher")
@Validated
class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeachers(){
        return teacherService.getTeacherList();
    }

    @PostMapping
    public void addTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
    }

    @PutMapping("/{teacherId}/students/{subjectId}")
    @ResponseStatus(value = HttpStatus.OK, reason = "Student enroll correctly")
    public void enrollStudentToSubject(@PathVariable Long subjectId, @PathVariable Long teacherId){
        teacherService.enrollStudentToSubject(subjectId, teacherId);

    }

}
