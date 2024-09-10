package students.student_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import students.student_management.model.StudentStatus;
import students.student_management.service.StudentStatusService;

import java.util.List;

@RestController
@RequestMapping("/student_status")
public class StudentStatusController {
    @Autowired
    private final StudentStatusService studentStatusService;

    public StudentStatusController(StudentStatusService studentStatusService) {
        this.studentStatusService = studentStatusService;
    }

    @GetMapping
    public ResponseEntity<List<StudentStatus>> getAllStudentStatuses() {
        return ResponseEntity.ok(studentStatusService.getAllStudentStatuses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentStatus> getStudentStatusById(@PathVariable Long id) {
        return ResponseEntity.ok(studentStatusService.getStudentStatusById(id));
    }

    @PostMapping()
    public ResponseEntity<StudentStatus> createStudentStatus(@RequestBody StudentStatus studentStatus) {
        return ResponseEntity.ok(studentStatusService.saveStudentStatus(studentStatus));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentStatus> updateStudentStatus(@PathVariable Long id, @RequestBody StudentStatus updatedStatus) {
        StudentStatus updatedStudentStatus = studentStatusService.updateStudentStatus(id, updatedStatus);
        return ResponseEntity.ok(updatedStudentStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentStatus(@PathVariable Long id) {
        studentStatusService.deleteStudentStatus(id);
        return ResponseEntity.noContent().build();
    }
}
