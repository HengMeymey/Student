package students.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import students.student_management.model.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {
}
