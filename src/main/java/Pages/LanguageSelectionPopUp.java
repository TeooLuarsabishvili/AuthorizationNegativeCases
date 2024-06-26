package Pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LanguageSelectionPopUp {
    WebElement georgianLanguageOption=null;
    WebElement megrelianLanguage=null;
    WebElement svanLanguage=null;

    @Step("check Georgian language option Appear On Pop UP")
    @Description("I check xpath from pop up div to make sure that pop up is displayed as well")
    public void checkGeorgianLanguageOptionPresence(WebDriver driver) {
        georgianLanguageOption = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='popup-wrapper']//div[@class='upper-wrapper']//p[contains(text(),'ქართული')]")));
    }

    @Step("click Megrelian language option on Languages Pop up")
    public void clickMegrelianLanguage(WebDriver driver) {
        megrelianLanguage = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'მეგრული')]")));
        megrelianLanguage.click();
    }

    @Step("click Svan language option on Languages Pop up")
    public void clickSvanLanguage(WebDriver driver) {
        svanLanguage = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'სვანური')]")));
        svanLanguage.click();
    }
}
