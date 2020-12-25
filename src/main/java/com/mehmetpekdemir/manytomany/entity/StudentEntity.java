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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "students")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "student_no", nullable = false, length = 20, unique = true)
	private String studentNo;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinTable(name = "student_course", //
			joinColumns = { @JoinColumn(name = "student_id") }, //
			inverseJoinColumns = { @JoinColumn(name = "course_id") })
	private Set<CourseEntity> courses = new HashSet<>();

	public StudentEntity(String studentNo, String firstName, String lastName) {
		this.studentNo = studentNo;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void addCourse(CourseEntity course) {
		this.courses.add(course);
		course.getStudents().add(this);
	}

	public void removeCourse(CourseEntity course) {
		this.courses.remove(course);
		course.getStudents().remove(this);
	}

	public void removeCourses() {
		for (CourseEntity course : new HashSet<>(courses)) {
			removeCourse(course);
		}
	}

}
