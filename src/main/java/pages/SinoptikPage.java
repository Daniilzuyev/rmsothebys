package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SinoptikPage extends BasePage {
    public SinoptikPage(WebDriver driver) {
        super(driver);
    }

    public WebElementFacade searchButton() {
        return element("#search_city").waitUntilVisible();
    }

    public void clickSearchButton() {
        $("[type='submit']").click();
    }

    public String clickTab() {
        $("#bd7").click();
        return $("#bd7 p").getText();
//        return day;
    }

    public List<Integer> getFullListPreasure() {
        List<WebElementFacade> elements = findAll(By.cssSelector(".weatherDetails .gray:nth-child(5) td")).stream().filter(WebElementFacade::isDisplayed).collect(Collectors.toList());
        List<Integer> artifacts = new ArrayList<Integer>();
        for(WebElement rowPreasure : elements){
                int preasure = Integer.parseInt(rowPreasure.getText());
            artifacts.add(preasure);
      };
        return artifacts;
    };
}

