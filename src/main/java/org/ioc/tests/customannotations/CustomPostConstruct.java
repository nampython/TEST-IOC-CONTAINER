package org.ioc.tests.customannotations;

import org.ioc.stereotype.AliasFor;
import org.ioc.stereotype.PostConstruct;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@AliasFor(PostConstruct.class)
public @interface CustomPostConstruct {
}
