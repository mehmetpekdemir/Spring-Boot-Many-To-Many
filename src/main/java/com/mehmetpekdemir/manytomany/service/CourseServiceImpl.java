package com.mehmetpekdemir.manytomany.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.manytomany.common.constant.ExceptionMessages;
import com.mehmetpekdemir.manytomany.entity.CourseEntity;
import com.mehmetpekdemir.manytomany.exception.CustomException;
import com.mehmetpekdemir.manytomany.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

	private final CourseRepository courseRepository;

	@Override
	@Transactional
	public void deleteCourse(String courseName) {
		final CourseEntity course = courseRepository.findByCourseName(courseName)
				.orElseThrow(() -> new CustomException(ExceptionMessages.COURSE_NOT_FOUND, HttpStatus.BAD_REQUEST));

		course.removeStudents();
		courseRepository.deleteById(course.getId());
	}

}
