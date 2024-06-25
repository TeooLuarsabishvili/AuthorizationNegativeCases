package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public  abstract class SetUp {
    public  WebDriver driver=WebDriverManager.chromedriver().create();
}
