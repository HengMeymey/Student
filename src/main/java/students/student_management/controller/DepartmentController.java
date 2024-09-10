package students.student_management.controller;

import org.springframework.http.HttpStatus;
import students.student_management.model.Department;
import students.student_management.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
//    @Autowired
//    private DepartmentService departmentService;
//
//    @GetMapping
//    public List<Department> getAllDepartments() {
//        return departmentService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Department> getDepartmentById(@PathVariable Integer id) {
//        return departmentService.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public Department createDepartment(@RequestBody Department department) {
//        return departmentService.save(department);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Department> updateDepartment(@PathVariable Integer id, @RequestBody Department department) {
//        if (!departmentService.findById(id).isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        department.setId(id);
//        return ResponseEntity.ok(departmentService.save(department));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteDepartment(@PathVariable Integer id) {
//        if (!departmentService.findById(id).isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        departmentService.deleteById(id);
////        return ResponseEntity.ok().build();
//        return new ResponseEntity<>("Success",HttpStatus.OK);
//    }

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.ok(savedDepartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
