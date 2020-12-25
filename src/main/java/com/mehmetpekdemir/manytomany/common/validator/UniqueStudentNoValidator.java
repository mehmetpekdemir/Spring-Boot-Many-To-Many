package com.mehmetpekdemir.manytomany.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mehmetpekdemir.manytomany.service.StudentService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RequiredArgsConstructor
public final class UniqueStudentNoValidator implements ConstraintValidator<UniqueStudentNo, String> {

	private final StudentService studentService;
	
	@Override
	public boolean isValid(String studentNo, ConstraintValidatorContext context) {
		return !studentService.existsStudentByStudentNo(studentNo);
	}

}
