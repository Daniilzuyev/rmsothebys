package steps;

import net.thucydides.core.annotations.Step;
import pages.ContactFormPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.CombinableMatcher.both;

public class ContactFromPageSteps {

    ContactFormPage page;

    @Step("Open page url: '{0}'")
    public void openPage(String url){
        page.get(url);
    }

    @Step("Click to Check availability button")
    public void clickChackAvaliabilityBtn() {
        page.clickCheckAvaliabilityBtn();
    }

    @Step("Enter in Name field {'0'}")
    public void fillName(String name) {
        page.getNameField(name);
        //page.waitForPageToLoad(15);
    }

    @Step("Enter in Address field {'0'}")
    public void fillMail(String address) {
        page.getAddressField(address);
       // page.waitForPageToLoad(15);
    }

    @Step("Enter in Address field {'0'}")
    public void fillPhoneNumber(int phoneNumber) {
        page.getPhoneNumber(String.valueOf(phoneNumber));
       // page.waitForPageToLoad(15);
    }

    @Step("Select country {'0'}")
    public void selectCountry(String countryName) {
        page.getCountry(countryName);
       // page.waitForPageToLoad(15);
    }

    @Step("Fill question info")
    public void fillHelpField(String helpMessage) {
        page.getHelpField(helpMessage);
        //page.waitForPageToLoad(15);
    }

    @Step("Fill Where did you hear about Crisalix?")
    public void fillHearField(String hearField) {
        page.getHearField(hearField);
        page.waitForPageToLoad(15);
    }

    @Step("Click submit button")
    public void clickSubmitBtn(){
        page.clickSubmitBtn();
        //assertThat();
    }

    @Step("check *contact sent* popup is visible")
    public void PopUpIsVisible() {
        page.checkPopUp().shouldNotBeVisible();
    }

}
