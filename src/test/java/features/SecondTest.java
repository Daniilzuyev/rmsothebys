package features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.PersonalCabinetSteps;

@Concurrent
@RunWith(SerenityRunner.class)
public class SecondTest {

    @Managed
    WebDriver driver;

    @Steps
    PersonalCabinetSteps page;

    @Title("Check uplaod photo in personal cabinet")
    @Test
    public void testSecondTask(){
        page.openPage("https://sso-staging.crisalix.com/users/sign_in");
        page.fillEmail("testing+qatest@crisalix.com");
        page.fillPassword("QaTesting1.");
        page.clickSignIn();
        page.clickNewPatient();
        page.fillNumber(21);
        page.uploadThreePhoto();
        page.clickSubmitBtn();

    }
}
