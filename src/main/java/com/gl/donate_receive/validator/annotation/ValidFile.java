package com.gl.donate_receive.validator.annotation;

import com.gl.donate_receive.validator.FileValidator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = FileValidator.class)
@Target({FIELD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface ValidFile {

	String message() default "Invalid file";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
