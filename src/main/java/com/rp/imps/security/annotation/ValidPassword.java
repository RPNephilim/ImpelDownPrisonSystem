package com.rp.imps.security.annotation;

import jakarta.validation.Constraint;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PasswordContraintsValidator.class)
public @interface ValidPassword {

    String message() default "Invalid password!";
}
