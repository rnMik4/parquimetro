package com.techchallege.parquimetro.services.validation;

import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CriacaoCondutorValid {
    String message() default  "Validation error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}