package students.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import students.student_management.model.Student;

import java.util.List;

@Repository
//public interface StudentRepository extends JpaRepository<Student, Integer> {
//
//    // Custom query method to find students by their status
//    List<Student> findByStudentStatusId(Integer studentStatusId);
//
//    // Custom query method to find students by their department
//    List<Student> findByDepartmentId(Integer departmentId);
//}
public interface StudentRepository extends JpaRepository<Student, Long> {
}
