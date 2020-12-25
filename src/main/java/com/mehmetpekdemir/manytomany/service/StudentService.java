package com.mehmetpekdemir.manytomany.service;

import com.mehmetpekdemir.manytomany.dto.request.StudentCreateRequest;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface StudentService {

	void createStudent(StudentCreateRequest studentCreateRequest);

	void deleteStudent(String studentNo);

	boolean existsStudentByStudentNo(String studentNo);

}
