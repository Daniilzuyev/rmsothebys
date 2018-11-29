package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalCabinetPage extends BasePage{

    public PersonalCabinetPage(WebDriver driver) {
        super(driver);
    }


    public WebElement getEmailField(String email) {
        return $("#user_email").waitUntilClickable().type(email);
    }

    public WebElement getPasswordField(String password) {
        return $("#user_password").waitUntilClickable().type(password);
    }

    public void clickLogInBtn() {
        $("[name='button']").waitUntilClickable().click();
    }

    public void clickNewPatientBtn() {
        $(".dashboard-menu li:nth-child(1)").click();
    }

    public WebElement fillNumber(int number) {
        return $("#n2n-js").type(String.valueOf(number));
    }

    public void uploadPhoto(String filePath) {
        $(".btn.btn--secondary-inverse.uploader-btn").click();
        upload(filePath).fromLocalMachine().to(getDriver().findElement(By.cssSelector(".btn.btn--secondary-inverse.uploader-btn")));
    }

    public void clickCreate3DBtn() {
        $(".upload-btn-wrap.mr-1").click();
    }
}
