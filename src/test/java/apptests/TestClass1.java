package apptests;

import com.spring.learning.myapp.browser.DriverHelper;
import com.spring.learning.myapp.pages.Page1;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@AllArgsConstructor
public class TestClass1 extends BaseTest {
    private final Page1 page1;
    private final DriverHelper driverHelper;

    @BeforeAll
    static void beforeAll() {
        System.out.println("TestClass1 - before class");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("TestClass1 - after class");
    }

    @Test
    public void testIt() {
        page1.openGooglePage();
        assertThat(driverHelper.getDriver().getTitle()).contains("Google");
    }

    @Test
    void name() {
        System.out.println("A");
    }
}
