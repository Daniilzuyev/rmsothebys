package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContactFormPage extends BasePage {

    public ContactFormPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckAvaliabilityBtn() {
        WebUtils.scrollToElement($(".modal__body [data-content='contact-us']"));
        $(".modal__body [data-content='contact-us']").waitUntilClickable().click();
    }

    public WebElement getNameField(String name) {
        return $(".modal__body [name='instant_contact[name]']").type(name);
    }

    public WebElement getAddressField(String mail) {
        return $(".modal__body [name='instant_contact[email]']").type(mail);
    }

    public WebElement getPhoneNumber(String phoneNumber) {
        return $(".modal__body [name='instant_contact[phone]']").type(phoneNumber);
    }

    public void getCountry(String countryName) {
            $(".modal__body [name='instant_contact[country_id]']").then(By.xpath(".//option[contains(text(),'" + countryName + "')]")).click();
    }

    public WebElement getHelpField(String helpMessage) {
        return $(".modal__body [name='instant_contact[reason]']").type(helpMessage);
    }

    public WebElement getHearField(String hearField) {
        return $(".modal__body [name='instant_contact[where]']").type(hearField);
    }

    public void clickSubmitBtn() {
        $(".modal__body [type='submit']").click();
    }

    public WebElementFacade checkPopUp() {
        return $(".modal.modal--default.open .modal__body:nth-child(2)").waitUntilVisible();
    }
}

