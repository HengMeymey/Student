package students.student_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import students.student_management.model.Time;
import students.student_management.repository.TimeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {
    @Autowired
    private TimeRepository timeRepository;

    public List<Time> findAll() {
        return timeRepository.findAll();
    }

    public Optional<Time> findById(Integer id) {
        return timeRepository.findById(id);
    }

    public Time save(Time time) {
        return timeRepository.save(time);
    }

    public void deleteById(Integer id) {
        timeRepository.deleteById(id);
    }
}
