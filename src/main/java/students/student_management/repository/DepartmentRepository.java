package students.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import students.student_management.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
