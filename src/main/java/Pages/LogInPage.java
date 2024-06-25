package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LogInPage  {

      WebElement language= null;
      WebElement userName= null;
      WebElement userPassword= null;
      WebElement submitButton= null;
      WebElement authorizationErrorMassage= null;


      @Step("check Main Page Url is correct")
      public  void checkMainPageUrl(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://mycredo.ge/landing/main/auth"));

    }

    @Step("find language option on main page")
    public   void findLanguage(WebDriver driver){
    new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#languageSwitcherBtn p")));
      language= driver.findElement(By.cssSelector("#languageSwitcherBtn p"));
  }

    @Step("get selected language text on main page")
    public  String getLanguageText(WebDriver driver){
    new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#languageSwitcherBtn p")));
      return driver.findElement(By.cssSelector("#languageSwitcherBtn p")).getText();
  }

    @Step("Fill user name with random input")
    public   void fillUserNameInput(WebDriver driver, String randomString){
        userName= new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#userName")));
        userName.sendKeys(randomString);
    }

    @Step("Fill user Password with random input")
    public   void fillUserPasswordInput(WebDriver driver, String randomString){
        userPassword= new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#newPass")));
        userPassword.sendKeys(randomString);
    }

    @Step("Click Submit Button for Authorization")
    public   void clickSubmitButton(WebDriver driver){
        submitButton= new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#submitAuth")));
        submitButton.click();
    }

    @Step("check Authorization text after wrong input")
    public  String checkAuthorizationErrorMassage(WebDriver driver){
        authorizationErrorMassage= new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#growlText")));
       return driver.findElement(By.cssSelector("#growlText")).getText();
    }


}

