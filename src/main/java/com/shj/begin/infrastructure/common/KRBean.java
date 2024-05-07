package com.shj.begin.infrastructure.common;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Indexed
@Component
@ConditionalOnProperty(name="country", havingValue = "KR")
public @interface KRBean {
}
