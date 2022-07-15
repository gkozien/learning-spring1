package apptests;

import com.spring.learning.myapp.context.launcher.MyLauncher;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyLauncher.class)
@AllArgsConstructor
public class BaseTest {

    @BeforeAll
    static void beforeClass() {
        System.out.println("BaseTest -  before class");
    }

    @AfterAll
    static void afterClass() {
        System.out.println("BaseTest - after class");
    }
}
