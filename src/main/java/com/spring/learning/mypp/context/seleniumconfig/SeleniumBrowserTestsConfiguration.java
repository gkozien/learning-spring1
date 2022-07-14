package com.spring.learning.mypp.context.seleniumconfig;

import com.spring.learning.mypp.pages.Page1;
import com.spring.learning.mypp.utils.selenium.DriverHelper;
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
        System.out.println("A");
    }
}
