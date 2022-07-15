package com.spring.learning.myapp.context.utils;

import com.spring.learning.myapp.context.config.SeleniumBrowserTestsConfiguration;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ContextLoader {
    private static ContextLoader instance;
    @Getter
    private AbstractApplicationContext applicationContext;

    private ContextLoader(Class<?> aClass) {
        applicationContext = prepareContext(aClass);
    }

    public static ContextLoader getInstance(Class<?> aClass) {
        if (instance == null) {
            instance = new ContextLoader(aClass);
        }
        return instance;
    }

    public AbstractApplicationContext prepareContext(Class<?> testClass) {
        log.info("building new context...");
        return new ContextBuilder()
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
