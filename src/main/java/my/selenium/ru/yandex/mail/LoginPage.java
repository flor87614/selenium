package my.selenium.ru.yandex.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MailPage login(String login, String password) {
        WebElement loginInput = driver.findElement(By.xpath("//input[@id='passp-field-login']"));
        loginInput.sendKeys(login);
        loginInput.sendKeys(Keys.ENTER);

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='passp-field-passwd']"));
        passwordInput.sendKeys(password);
        passwordInput.sendKeys(Keys.ENTER);

        return new MailPage(driver);
    }
}
