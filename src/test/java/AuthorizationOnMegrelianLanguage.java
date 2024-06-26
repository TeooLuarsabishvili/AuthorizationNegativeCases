import Data.LogInPageData;
import Pages.LogInPage;
import Pages.SetUp;
import io.qameta.allure.Feature;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.LanguageSelectionPopUp;
import org.testng.asserts.SoftAssert;

public class AuthorizationOnMegrelianLanguage extends SetUp {
    LogInPage logInPage = new LogInPage();
    SoftAssert softAssert = new SoftAssert();
    LogInPageData loginPageData = new LogInPageData();
    public   String userName = RandomStringUtils.randomAlphabetic(5);
    LanguageSelectionPopUp languageSelectionPopUp = new LanguageSelectionPopUp();
    public   String Password = RandomStringUtils.randomNumeric(5)+RandomStringUtils.randomAlphabetic(8);

    @BeforeMethod
    public void setUp(){
        driver.manage().window().maximize();
        driver.get("https://mycredo.ge/landing/main/auth");
    }

    @DataProvider
    public Object[][] dpMethod(){
        return new Object[][] {{userName}, {Password}};
    }

    @Feature("Negative case of Authorization for Megrelian Language")
    @Test
    public void failedAuthorizationMegrelianLanguage() {
        logInPage.checkMainPageUrl(driver);
        logInPage.findLanguage(driver);
        softAssert.assertEquals(loginPageData.georgianLanguage,(logInPage.getLanguageText(driver)));
        logInPage.clickLanguage(driver);
        languageSelectionPopUp.checkGeorgianLanguageOptionPresence(driver);
        languageSelectionPopUp.clickMegrelianLanguage(driver);
        softAssert.assertEquals(loginPageData.megrelianLanguage,(logInPage.getLanguageTextForMegrelianLanguage(driver)));
        softAssert.assertEquals(logInPage.getLogInToTheSystemTextForMegrelianLanguage(driver),loginPageData.logInToTheSystemTextMegrelian);
        logInPage.fillUserNameInput(driver, userName);
        logInPage.fillUserPasswordInput(driver,Password);
        logInPage.clickSubmitButton(driver);
        softAssert.assertEquals(logInPage.checkAuthorizationErrorMassage(driver),loginPageData.authorizationErrorMassageOnMegrelianLanguage);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
