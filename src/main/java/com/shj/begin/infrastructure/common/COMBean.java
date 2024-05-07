package com.shj.begin.infrastructure.common;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;
import java.util.Arrays;
import java.util.Map;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Conditional({COMBean.ComCondition.class})
public @interface COMBean {

    String[] value() default {};

    class ComCondition implements Condition {
        public ComCondition() {
        }

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            Environment environment = context.getEnvironment();
            String country = environment.getProperty("country");

            if (country == null) {
                return false;
            }

            Map<String, Object> attributes = metadata.getAnnotationAttributes(COMBean.class.getName());
            String[] countries = (String[]) attributes.get("value");

            if (countries.length == 0) {
                return true;
            }

            return Arrays.asList(countries).contains(country);
        }
    }
}
