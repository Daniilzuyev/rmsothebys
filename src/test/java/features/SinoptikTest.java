package features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.SinoptikPageSteps;

@Concurrent
@RunWith(SerenityRunner.class)
public class SinoptikTest {

    @Managed
    WebDriver driver;

    @Steps
    SinoptikPageSteps page;

    @Title("Check Sinoptik page")
    @Test
    public void sinoptikPage() throws InterruptedException {
        page.openPage("http://www.sinoptik.ua");
        page.checkCurrentUrl();
        page.enterNameRegion("Драгобрат");
        page.clickSearch();
        page.chewckSelectedTab();
        page.checkRangePreasure();
        Thread.sleep(1000);
    }

}
