package students.student_management.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(nullable = false, length = 60)
//    private String name;
//
//    @Column(nullable = false, unique = true, length = 30)
//    private String contact;
//
//    @Column(nullable = false)
//    private java.sql.Date dob;
//
//    @Column(nullable = false, length = 10)
//    private String gender;
//
//    @ManyToOne
//    @JoinColumn(name = "student_status_id", nullable = false)
//    private StudentStatus studentStatus;
//
//    @ManyToOne
//    @JoinColumn(name = "department_id", nullable = false)
//    private Department department;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false, unique = true, length = 30)
    private String contact;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(nullable = false, length = 10)
    private String gender;

//    @ManyToOne
//    @JoinColumn(name = "student_status_id", nullable = false)
//    private StudentStatus studentStatus;
//
//    @ManyToOne
//    @JoinColumn(name = "department_id", nullable = false)
//    private Department department;

    @ManyToOne
    @JoinColumn(name = "student_status_id", nullable = false)
//    @JsonBackReference  // Prevent infinite recursion
    @JsonManagedReference  // Include studentStatus in the JSON response
    private StudentStatus studentStatus;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
}
