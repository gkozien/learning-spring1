package apptests;

import com.spring.learning.myapp.browser.DriverHelper;
import com.spring.learning.myapp.pages.Page2;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


@AllArgsConstructor
public class TestClass2 extends BaseTest {
    private final Page2 page2;
    private final DriverHelper driverHelper;

    @Test
    public void testIt() {
        page2.openWirtualPolskaPage();
        assertThat(driverHelper.getDriver().getTitle()).contains("Wirtualna Polska");
    }
}
