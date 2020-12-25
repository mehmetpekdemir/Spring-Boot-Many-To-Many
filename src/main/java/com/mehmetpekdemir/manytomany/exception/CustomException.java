package com.mehmetpekdemir.manytomany.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RequiredArgsConstructor
public final class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String message;

	@Getter
	private final HttpStatus httpStatus;

	@Override
	public String getMessage() {
		return message;
	}

}