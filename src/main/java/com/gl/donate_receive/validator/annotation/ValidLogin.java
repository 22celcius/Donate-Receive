package com.gl.donate_receive.validator.annotation;

import com.gl.donate_receive.validator.LoginValidator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = LoginValidator.class)
@Target({FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface ValidLogin {

	String message() default "Invalid Login";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
