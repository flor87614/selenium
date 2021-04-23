package my.selenium.ru.yandex.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage {
    private WebDriver driver;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage enter() {
        WebElement enterButton = driver.findElement(By.xpath("//a[contains(@class, 'HeadBanner-Button-Enter')]"));
        enterButton.click();

        return new LoginPage(driver);
    }
}
