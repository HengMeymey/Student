package students.student_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import students.student_management.exception.ResourceNotFoundException;
import students.student_management.model.StudentStatus;
import students.student_management.repository.StudentStatusRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentStatusService {

    @Autowired
    private final StudentStatusRepository studentStatusRepository;

    public StudentStatusService(StudentStatusRepository studentStatusRepository) {
        this.studentStatusRepository = studentStatusRepository;
    }

    public List<StudentStatus> getAllStudentStatuses() {
        return studentStatusRepository.findAll();
    }

    public StudentStatus getStudentStatusById(Long id) {
        return studentStatusRepository.findById(id).orElse(null);
    }

    public StudentStatus saveStudentStatus(StudentStatus studentStatus) {
        return studentStatusRepository.save(studentStatus);
    }

    public StudentStatus updateStudentStatus(Long id, StudentStatus updatedStatus) {
        StudentStatus existingStatus = studentStatusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StudentStatus not found with id: " + id));

        existingStatus.setName(updatedStatus.getName());
        return studentStatusRepository.save(existingStatus);
    }

    public void deleteStudentStatus(Long id) {
        studentStatusRepository.deleteById(id);
    }
}