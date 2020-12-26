package com.mehmetpekdemir.manytomany.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.mehmetpekdemir.manytomany.common.validator.UniqueStudentNo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class StudentCreateRequest {

	@NotNull
	@NotEmpty
	@UniqueStudentNo
	private String studentNo;

	@NotNull
	@NotEmpty
	private String firstName;

	@NotNull
	@NotEmpty
	private String lastName;

	@NotNull
	@NotEmpty
	private String courseName;

}
