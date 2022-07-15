package com.spring.learning.myapp.context.config;

import com.spring.learning.myapp.browser.DriverHelper;
import com.spring.learning.myapp.pages.Page1;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.context.annotation.Lazy;

//@Configuration
@ComponentScan(
        nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class,
        basePackageClasses = {Page1.class, DriverHelper.class},     //this class and all others in same package
        lazyInit = true)
//@Import({SomeSpecificClassToBeImportedIndividually.class})        //only this class
@Lazy
public class SeleniumBrowserTestsConfiguration {
    public SeleniumBrowserTestsConfiguration() {
    }
}
