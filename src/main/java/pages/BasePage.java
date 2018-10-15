package pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class BasePage extends PageObject {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public void get(String url) {
        getDriver().get(url);

        getDriver().manage().window().maximize();
    }

    public String getUrl() {
        return getDriver().getCurrentUrl();
    }

    public static void wait(int mls) {
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForPageToLoad(int retry) {
        int count = 0;

        while (count < retry) {

            wait(1000);

            System.out.print(".");
            if (((JavascriptExecutor) getDriver())
                    .executeScript("return (document.readyState == 'complete' && jQuery.active == 0);").equals(true)) {
                System.out.println(".");
                return;
            }

            count++;
        }
    }
}
