package apptests;

import com.spring.learning.myapp.pages.Page1;
import com.spring.learning.myapp.browser.DriverHelper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@AllArgsConstructor
public class TestClass1 extends BaseTest {
    private final Page1 page1;
    private final DriverHelper driverHelper;

    @Test
    public void testIt() {
        driverHelper.initiateChrome();
        page1.openGooglePage();
        assertThat(driverHelper.getDriver().getTitle()).contains("Google");
    }
}
