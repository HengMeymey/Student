package students.student_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "time")
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private float start_time;
    private float end_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public float getStart_time() {
        return start_time;
    }

    public void setStart_time(float start_time) {
        this.start_time = start_time;
    }
    public float getEnd_time() {
        return end_time;
    }

    public void setEnd_time(float end_time) {
        this.end_time = end_time;
    }

    public Time() {
    }
    public Time(Integer id, String name,float start_time,float end_time) {
        this.id = id;
        this.name = name;
        this.start_time = start_time;
        this.end_time = end_time;
    }
}
