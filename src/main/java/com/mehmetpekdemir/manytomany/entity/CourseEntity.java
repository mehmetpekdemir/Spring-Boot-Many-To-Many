package com.mehmetpekdemir.manytomany.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class CourseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "course_name", nullable = false, length = 50, unique = true)
	private String courseName;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, mappedBy = "courses")
	private Set<StudentEntity> students = new HashSet<>();

	public CourseEntity(String courseName) {
		this.courseName = courseName;
	}

	public void removeStudent(StudentEntity student) {
		this.getStudents().remove(student);
		student.getCourses().remove(this);
	}

	public void removeStudents() {
		for (StudentEntity student : new HashSet<>(students)) {
			removeStudent(student);
		}
	}

}
