package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pages.MainPage;
import praktikum.pages.StatusPage;

public class ScooterTest {
    @Rule
    public DriverRule factory = new DriverRule();

    private String INVALID_ORDER_ID = "123";

    @Test
    public void openMainPage() throws Exception {
        WebDriver driver = factory.getDriver();
        var mainPain = new MainPage(driver);

        mainPain.open();

        mainPain.clickOnStatus();
        mainPain.enterOrderId(INVALID_ORDER_ID);

        StatusPage statusPage = mainPain.clickOnGo();
        statusPage.checkErrorMessage();
    }
}
