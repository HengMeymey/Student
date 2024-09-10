package students.student_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import students.student_management.model.Department;
import students.student_management.model.Student;
import students.student_management.model.StudentStatus;

import java.util.Date;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
//		StudentStatus status = new StudentStatus(1, "Active");
//		Department department = new Department(1, "Computer Science");
//
//		// Create a Student object
//		Student student = new Student(
//				1,
//				"John Doe",
//				"0123456789",
//				new Date(),
//				"Male",
//				status,
//				department
//		);
//
//		// Print the StudentStatus of the student
//		System.out.println("Student Status: " + student.getStudentStatus());

	}

//	@GetMapping()
//	public String Test(){
//		return "Hello";
//	}

}
