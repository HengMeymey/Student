package students.student_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import students.student_management.model.Time;
import students.student_management.service.TimeService;

import java.util.List;

@RestController
@RequestMapping("/time")
public class TimeController {
    @Autowired
    private TimeService timeService;

    @GetMapping
    public List<Time> getAllTimes() {
        return timeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> getTimeById(@PathVariable Integer id) {
        return timeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Time createTime(@RequestBody Time time) {
        return timeService.save(time);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> updateTime(@PathVariable Integer id, @RequestBody Time time) {
        if (!timeService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        time.setId(id);
        return ResponseEntity.ok(timeService.save(time));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTime(@PathVariable Integer id) {
        if (!timeService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        timeService.deleteById(id);
//        return ResponseEntity.ok().build();
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
