package com.spring.learning.myapp.context.launcher;

import com.spring.learning.myapp.context.utils.ContextLoader;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MyLauncher implements ParameterResolver, BeforeAllCallback {
    private AbstractApplicationContext context;

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        context = ContextLoader.getInstance(extensionContext.getTestClass().get()).getApplicationContext();
    }

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
        return context.getBean(parameterContext.getParameter()
                .getType());
    }

    private static <K, V> Map<K, V> toMap(K key, V value) {
        Map<K, V> map = new HashMap<>();
        map.put(key, value);
        return map;
    }
}
