package com.spring.learning.myapp.context.utils;

import org.springframework.context.support.AbstractApplicationContext;

public class ContextHelper {

    public void initializeStaticContext(AbstractApplicationContext context) {
        context.getBeansOfType(StaticContextInitializer.class)
                .forEach((beanName, initializer) -> {
                    initializer.initializeStaticContext();
                });
    }
}
