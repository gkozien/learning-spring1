package com.spring.learning.mypp.context.launcher;

import com.spring.learning.mypp.context.seleniumconfig.SeleniumBrowserTestsConfiguration;
import com.spring.learning.mypp.context.utils.ContextBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MyLauncher implements ParameterResolver {
    private AbstractApplicationContext context;

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        try {
            resolveParameter(parameterContext, extensionContext);
            return true;
        } catch (ParameterResolutionException e) {
            return false;
        }
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        if (context == null) {
            prepareContext(extensionContext.getTestClass().get());
        }
        return context.getBean(parameterContext.getParameter()
                .getType());
    }

    private void prepareContext(Class<?> testClass) {
        log.info("building new context...");
        context = new ContextBuilder()
//                .activeProfiles(activeProfiles(env, testClass))
                .beans(toMap(testClass.getName(), testClass))
                .componentClasses(new Class<?>[]{SeleniumBrowserTestsConfiguration.class})
                .initializeStaticContext(true)
                .build();
    }

    private static <K, V> Map<K, V> toMap(K key, V value) {
        Map<K, V> map = new HashMap<>();
        map.put(key, value);
        return map;
    }
}
