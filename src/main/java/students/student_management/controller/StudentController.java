package students.student_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import students.student_management.model.Student;
import students.student_management.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

//    @Autowired
//    private StudentService studentService;
//
//    @GetMapping
//    public ResponseEntity<List<Student>> getAllStudents() {
//        List<Student> students = studentService.findAll();
//        return ResponseEntity.ok(students);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
//        Optional<Student> student = studentService.findById(id);
//        return student.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
//    }
//
//    @PostMapping
//    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
//        try {
//            Student savedStudent = studentService.save(student);
//            return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
//        if (!studentService.existsById(id)) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//        student.setId(id);
//        try {
//            Student updatedStudent = studentService.save(student);
//            return ResponseEntity.ok(updatedStudent);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
//        if (!studentService.existsById(id)) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        studentService.deleteById(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}