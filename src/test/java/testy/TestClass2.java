package testy;

import com.spring.learning.mypp.pages.Page2;
import com.spring.learning.mypp.utils.selenium.DriverHelper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@AllArgsConstructor
public class TestClass2 extends BaseTest {
    private final Page2 page2;
    private final DriverHelper driverHelper;

    @Test
    public void testIt() {
        driverHelper.initiateChrome();
        page2.openWirtualPolskaPage();
        assertThat(driverHelper.getDriver().getTitle()).contains("Wirtualna Polska");
    }
}
