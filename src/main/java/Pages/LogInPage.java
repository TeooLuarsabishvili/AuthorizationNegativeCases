package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LogInPage {

    WebElement language = null;
    WebElement userName = null;
    WebElement userPassword = null;
    WebElement submitButton = null;
    WebElement authorizationErrorMassage = null;
    WebElement LogInToSystemTextSvan = null;
    WebElement LogInToSystemTextMegrelian = null;




    @Step("check Main Page Url is correct")
    public void checkMainPageUrl(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://mycredo.ge/landing/main/auth"));

    }

    @Step("find language option on main page")
    public void findLanguage(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#languageSwitcherBtn p")));
        language = driver.findElement(By.cssSelector("#languageSwitcherBtn p"));
    }

    @Step("get selected language text on main page")
    public String getLanguageText(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#languageSwitcherBtn p")));
        return driver.findElement(By.cssSelector("#languageSwitcherBtn p")).getText();
    }

    @Step("get language text after selection of Megrelian language on main page")
    public String getLanguageTextForMegrelianLanguage(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(7)).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("#languageSwitcherBtn p")),"მეგ"));
        return driver.findElement(By.cssSelector("#languageSwitcherBtn p")).getText();
    }

    @Step("get language text after selection of Svan language on main page")
    public String getLanguageTextForSvanLanguage(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(7)).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("#languageSwitcherBtn p")),"სვან"));
        return driver.findElement(By.cssSelector("#languageSwitcherBtn p")).getText();
    }

    @Step("Fill user name with random input")
    public void fillUserNameInput(WebDriver driver, String randomString) {
        userName = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.id("userName")));
        userName.sendKeys(randomString);
    }

    @Step("Fill user Password with random input")
    public void fillUserPasswordInput(WebDriver driver, String randomString) {
        userPassword = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.id("newPass")));
        userPassword.sendKeys(randomString);
    }

    @Step("Click Submit Button for Authorization")
    public void clickSubmitButton(WebDriver driver) {
        submitButton = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.id("submitAuth")));
        submitButton.click();
    }

    @Step("check Authorization text after wrong input")
    public String checkAuthorizationErrorMassage(WebDriver driver) {
        authorizationErrorMassage = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.id("growlText")));
        return driver.findElement(By.cssSelector("#growlText")).getText();
    }

    @Step("click language option on main page")
    public void clickLanguage(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#languageSwitcherBtn p")));
        language = driver.findElement(By.cssSelector("#languageSwitcherBtn p"));
        language.click();
    }
    @Step("get Log Into system text In Megrelian Language=")
    public String getLogInToTheSystemTextForMegrelianLanguage(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("#authloading p.block-header-caps-20")),"სისტემაშა მიშულა"));
        LogInToSystemTextMegrelian = driver.findElement(By.cssSelector("#authloading p.block-header-caps-20"));
        return LogInToSystemTextMegrelian.getText();
    }

    @Step("get Log Into system text In svan Language =")
    public String getLogInToTheSystemTextForSvanLanguage(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("#authloading p.block-header-caps-20")),"სისტემათეისგა სგა ლიზი"));
        LogInToSystemTextSvan = driver.findElement(By.cssSelector("#authloading p.block-header-caps-20"));
        return LogInToSystemTextSvan.getText();
    }
}

