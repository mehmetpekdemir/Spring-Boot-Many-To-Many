package com.mehmetpekdemir.manytomany.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mehmetpekdemir.manytomany.common.GenericResponse;
import com.mehmetpekdemir.manytomany.common.annotation.ApiController;
import com.mehmetpekdemir.manytomany.common.constant.GenericMessages;
import com.mehmetpekdemir.manytomany.service.CourseService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@ApiController
@RequiredArgsConstructor
public class CourseController {

	private final CourseService courseService;

	@DeleteMapping("v1/course")
	public ResponseEntity<?> deleteCourse(@RequestParam(name = "courseName") String courseName) {

		courseService.deleteCourse(courseName);
		return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_DELETED));
	}

}
