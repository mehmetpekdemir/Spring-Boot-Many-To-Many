package com.mehmetpekdemir.manytomany;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.mehmetpekdemir.manytomany.entity.CourseEntity;
import com.mehmetpekdemir.manytomany.entity.StudentEntity;
import com.mehmetpekdemir.manytomany.repository.CourseRepository;
import com.mehmetpekdemir.manytomany.repository.StudentRepository;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@SpringBootApplication
public class ManyToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

	@Bean
	CommandLineRunner createInitialData(StudentRepository studentRepository, CourseRepository courseRepository) {
		return (args) -> {

			StudentEntity student = new StudentEntity("123456", "Mehmet", "Pekdemir");
			CourseEntity course = new CourseEntity("Java 11");

			student.addCourse(course);
			studentRepository.save(student);

		};
	}

}
