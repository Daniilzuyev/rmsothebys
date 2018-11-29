package features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.ContactFromPageSteps;

@Concurrent
@RunWith(SerenityRunner.class)
public class FirstTest {

    @Managed
    WebDriver driver;

    @Steps
    ContactFromPageSteps page;

    @Title("Check Contacts form sent")
    @Test
    public void contactForm(){
        page.openPage("https://crisalix-staging.crisalix.com/en/doctor");
        page.clickChackAvaliabilityBtn();
        page.fillName("Leo");
        page.fillMail("test@test.com");
        page.fillPhoneNumber(911);
        page.selectCountry("United States");
        page.fillHelpField("please recommend me on of your services");
        page.fillHearField("recomendation from Cristiano");
        page.clickSubmitBtn();
        page.PopUpIsVisible();
    }

}
