package com.mehmetpekdemir.manytomany.common.constant;

/**
 * 
 * Swagger Api Response Messages
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public final class SwaggerMessages {

	private static final String UTILITY_CLASS = "Utility Class";

	private SwaggerMessages() {
		throw new IllegalArgumentException(UTILITY_CLASS);
	}

	public static final String SUCCESSFULLY_COMPLETED = "Successfully completed.";

	public static final String SUCCESSFULLY_CREATED = "Successfully created.";

	public static final String SUCCESSFULLY_UPDATED = "Successfully updated.";

	public static final String SUCCESSFULLY_DELETED = "Successfully deleted.";

	public static final String FORBIDDEN = "Accessing the resource you were trying to reach is forbidden.";

	public static final String BAD_REQUEST = "Bad request.";

}
