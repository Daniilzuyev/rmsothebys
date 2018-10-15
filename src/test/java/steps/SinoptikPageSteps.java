package steps;

import net.thucydides.core.annotations.Step;
import pages.BasePage;
import pages.SinoptikPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.CombinableMatcher.both;

public class SinoptikPageSteps {

    BasePage basePage;
    SinoptikPage page;

    @Step("Open page url: '{0}'")
    public void openPage(String url){
        basePage.get(url);
    }

    @Step("Check page is opened")
    public void checkCurrentUrl(){
        assertThat(page.getUrl(), containsString("https://sinoptik.ua"));
    }

    @Step("enter name of region / city / village")
    public void enterNameRegion(String regionName) {
        page.searchButton().type(regionName);
    }

    @Step("")
    public void clickSearch() {
        page.clickSearchButton();
        page.waitForPageToLoad(15);
    }

    @Step("check selected tab is 'Воскресенье'")
    public void chewckSelectedTab() {
        assertThat(page.clickTab(), containsString("Воскресенье"));
    }

    @Step("check preasure is in range between 600 and 700")
    public void checkRangePreasure() {
        page.waitForPageToLoad(15);
        for (Integer preasure : page.getFullListPreasure()) {
            assertThat(preasure, is(both(greaterThan(600)).and(lessThan(800))));
        }
    }

}
