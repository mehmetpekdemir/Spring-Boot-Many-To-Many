package com.mehmetpekdemir.manytomany.common.constant;

/**
 * 
 * Exception Messages
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public final class ExceptionMessages {

	private static final String UTILITY_CLASS = "Utility Class";

	private ExceptionMessages() {
		throw new IllegalArgumentException(UTILITY_CLASS);
	}

	public static final String COURSE_NOT_FOUND = "Course not found !";

	public static final String STUDENT_NOT_FOUND = "Student not found !";

}
