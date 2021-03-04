package pl.tomozak.learningAmigoscode.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.tomozak.learningAmigoscode.models.Subject;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/subject")
@Validated
class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }


    @GetMapping
    public List<Subject> getSubjects() {
        return subjectService.getListOfSubject();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK, reason = "Subject added correctly")
    public void createSubject(@Validated @RequestBody Subject subject) {
        subjectService.addNewSubject(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    @ResponseStatus(value = HttpStatus.OK, reason = "Student enroll correctly")
    public void enrollStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId){
        subjectService.enrollStudentToSubject(subjectId, studentId);

    }




}
