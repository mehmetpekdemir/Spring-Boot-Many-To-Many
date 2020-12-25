package com.mehmetpekdemir.manytomany.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mehmetpekdemir.manytomany.common.GenericResponse;
import com.mehmetpekdemir.manytomany.common.annotation.ApiController;
import com.mehmetpekdemir.manytomany.common.constant.GenericMessages;
import com.mehmetpekdemir.manytomany.dto.request.StudentCreateRequest;
import com.mehmetpekdemir.manytomany.service.StudentService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@ApiController
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

	@PostMapping("v1/student")
	public ResponseEntity<?> createStudent(@Valid @RequestBody StudentCreateRequest studentCreateRequest) {

		studentService.createStudent(studentCreateRequest);
		return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_CREATED));
	}

	@DeleteMapping("v1/student")
	public ResponseEntity<?> deleteStudent(@RequestParam(name = "studentNo") String studentNo) {

		studentService.deleteStudent(studentNo);
		return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_DELETED));
	}

}
