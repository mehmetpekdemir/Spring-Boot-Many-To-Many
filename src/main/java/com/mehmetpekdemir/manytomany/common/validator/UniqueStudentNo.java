package com.mehmetpekdemir.manytomany.common.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { UniqueStudentNoValidator.class })
public @interface UniqueStudentNo {

	String message() default "{many-to-many.constraints.UniqueStudentNo.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
