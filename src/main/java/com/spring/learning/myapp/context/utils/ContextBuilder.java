package com.spring.learning.myapp.context.utils;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Map;
import java.util.function.Consumer;

/**
 * Creates context and refreshes it.
 */
@Accessors(fluent = true)
@Setter
@Slf4j
public class ContextBuilder {
    private String[] activeProfiles;
    private Map<String, Class<?>> beans;
    private Class<?>[] componentClasses;
    private Consumer<AbstractApplicationContext> registerSingletonsMethod;
    private Map<Class<?>, Object> resolvableDependencies;
    private boolean initializeStaticContext = false;

    @Setter(value = AccessLevel.NONE)
    private ContextHelper contextHelper = new ContextHelper();

    public AbstractApplicationContext build() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        if (null != activeProfiles) {
            context.getEnvironment()
                .setActiveProfiles(activeProfiles);
        }
        if (null != beans) {
            beans.forEach((beanName, beanClass) -> {
                context.registerBean(beanName, beanClass);
                context.getBeanDefinition(beanName)
                    .setLazyInit(true);
            });
        }
        if (null != componentClasses) { context.register(componentClasses); }
        if (null != registerSingletonsMethod) { registerSingletonsMethod.accept(context); }
        if (null != resolvableDependencies) {
            resolvableDependencies.forEach(context.getBeanFactory()::registerResolvableDependency);
        }
        log.debug("Refreshing Spring context.");
        context.refresh();
        if (initializeStaticContext) {
            log.debug("Initializing static context.");
            contextHelper.initializeStaticContext(context);
        }
        return context;
    }
}
