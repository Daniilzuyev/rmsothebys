package steps;

import net.thucydides.core.annotations.Step;
import pages.PersonalCabinetPage;

public class PersonalCabinetSteps {

    PersonalCabinetPage page;

    @Step("Open page url: '{0}'")
    public void openPage(String url){
        page.get(url);
    }

    @Step("Enter email")
    public void fillEmail(String email) {
        page.getEmailField(email);
    }

    @Step("Enter password")
    public void fillPassword(String password) {
        page.getPasswordField(password);
    }

    @Step("click submit button")
    public void clickSignIn(){
        page.clickLogInBtn();
    }

    @Step("Click New Patient")
    public void clickNewPatient(){
        page.clickNewPatientBtn();
    }

    @Step("Fill number in 'nipple to nipple distance' field ")
    public void fillNumber(int num){
        page.fillNumber(num);
    }

    @Step("upload 3 photos")
    public void uploadThreePhoto(){
        page.uploadPhoto("D:\\184441.png");
        page.uploadPhoto("D:\\40792.png");
        page.uploadPhoto("D:\\215981.png");
    }

    @Step
    public void clickSubmitBtn() {
        page.clickCreate3DBtn();
    }
}
