package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.*;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class WebUtils {

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToElement(WebElement element, int timeout) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        wait(timeout);
    }

    public static void scrollToElementToTop(WebElement element, int top) {
        String script = "var pos = $(arguments[0]).offset(); \nvar top = pos.top - " + top + ";"
                + "\n var left = pos.left; \nwindow.scrollTo((left < 0 ? 0 : left), (top < 0 ? 0 : top));";

        ((JavascriptExecutor) getDriver()).executeScript(script, element);
    }

    public static void jsClick(WebElement el) {
        String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj."
                + "initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} "
                + "else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";

        String onClickScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('click',"
                + "true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject)"
                + "{ arguments[0].fireEvent('onclick');}";

        ((JavascriptExecutor) getDriver()).executeScript(mouseOverScript, el);
        ((JavascriptExecutor) getDriver()).executeScript(onClickScript, el);

    }

    public static String getRandomEmail() {
        Random random = new Random();
        int number = random.nextInt(10000);
        return String.format("test%s@gmail.com", number);
    }

    public static String getRandomString() {
        return RandomStringUtils.randomAlphanumeric(17).toUpperCase();
    }

    public static void wait(int mls) {
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementToDisplayed(By locator) {
        int count = 0;

        while (count < 30) {
            wait(1000);

            System.out.print(".");

            if (getDriver().findElements(locator).stream().filter(WebElement::isDisplayed).count() > 0) {
                System.out.println(".");
                return;
            }

            count++;
        }
    }

    public static void waitUntilElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementDisappear(By locator)
    {
        int count = 0;

        while (count < 20) {
            wait(1000);

            System.out.print(".");

            if (getDriver().findElements(locator).stream().filter(WebElement::isDisplayed).count() < 0) {
                System.out.println(".");
                return;
            }

            count++;
        }
    }

    public static void waitForPageToLoad(int retry) {
        int count = 0;

        while (count < retry) {

            wait(1000);

            System.out.print(".");
            if (((JavascriptExecutor) getDriver())
                    .executeScript("if (typeof jQuery !== \"undefined\") {return (document.readyState == 'complete' && jQuery.active == 0);} else {return true;}").equals(true)) {
                System.out.println(".");
                return;
            }

            count++;
        }
    }

    public static void waitForPageToLoad() {
        waitForPageToLoad(20);
    }

    public static String getHiddenText(WebElement el) {
        return (String) ((JavascriptExecutor) getDriver()).executeScript("return jQuery(arguments[0]).text();", el);
    }

    public static String getCurrentDateByFormat(String format) {
        Locale locale = new Locale("en", "CANADA");
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
        return sdf.format(date);
    }

    public static Actions getAction() {
        return new Actions(getDriver());
    }

    public static void clickToCoordinates(WebElement el, int horizontal, int vertical) {
        getAction().moveToElement(el).moveByOffset(horizontal, vertical).click().build().perform();
    }

    public static void mouseHoverElement(By locator) {
        Actions action = new Actions(getDriver());
        WebElement we = getDriver().findElement(locator);
        action.moveToElement(we).perform();
    }

    public static void focus(WebElement el) {
        ((JavascriptExecutor) getDriver()).executeScript("jQuery(arguments[0]).focus();", el);
    }

    public static String getInnerHtml(WebDriver driver, WebElement element) {
        return ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;", element).toString();
    }

    public static void waitVisibilityOfElementLocated(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void freezeRefresh() {
        ((JavascriptExecutor) getDriver()).executeScript(
                "var p=window.XMLHttpRequest.prototype; p.open=p.send=p.setRequestHeader=function(){};"
        );
    }
}
