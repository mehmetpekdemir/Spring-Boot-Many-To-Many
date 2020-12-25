package com.mehmetpekdemir.manytomany.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.manytomany.common.constant.ExceptionMessages;
import com.mehmetpekdemir.manytomany.dto.request.StudentCreateRequest;
import com.mehmetpekdemir.manytomany.entity.CourseEntity;
import com.mehmetpekdemir.manytomany.entity.StudentEntity;
import com.mehmetpekdemir.manytomany.exception.CustomException;
import com.mehmetpekdemir.manytomany.repository.CourseRepository;
import com.mehmetpekdemir.manytomany.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;

	@Override
	@Transactional
	public void createStudent(StudentCreateRequest studentCreateRequest) {
		final CourseEntity course = courseRepository.findByCourseName(studentCreateRequest.getCourseName())
				.orElseThrow(() -> new CustomException(ExceptionMessages.COURSE_NOT_FOUND, HttpStatus.BAD_REQUEST));

		StudentEntity student = new StudentEntity(studentCreateRequest.getStudentNo(),
				studentCreateRequest.getFirstName(), studentCreateRequest.getLastName());

		student.addCourse(course);
		studentRepository.save(student);
	}

	@Override
	@Transactional
	public void deleteStudent(String studentNo) {
		final StudentEntity student = studentRepository.findByStudentNo(studentNo)
				.orElseThrow(() -> new CustomException(ExceptionMessages.STUDENT_NOT_FOUND, HttpStatus.BAD_REQUEST));

		student.removeCourses();
		studentRepository.deleteById(student.getId());
	}

	@Override
	@Transactional
	public boolean existsStudentByStudentNo(String studentNo) {
		return studentRepository.existsStudentByStudentNo(studentNo);
	}

}
