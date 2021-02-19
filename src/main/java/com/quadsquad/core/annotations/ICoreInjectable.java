package com.quadsquad.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ICoreComponent
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ICoreInjectable {
}
