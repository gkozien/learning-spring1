package testy;

import com.codeborne.selenide.Selenide;
import com.spring.learning.mypp.context.launcher.MyLauncher;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyLauncher.class)
public class BaseTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all (even before context loads)...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
        Selenide.closeWebDriver();
    }
}
