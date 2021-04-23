package my.selenium.ru.yandex.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MailPage {
    private WebDriver driver;

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    public int countMailsBySubject(String subject) {
        List<WebElement> mails = driver.findElements(By.xpath("//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_subject']/span[text()='" + subject + "']"));
        return mails.size();
    }

    public SendMailForm createMail() {
        WebElement writeButton = driver.findElement(By.xpath("//a[contains(@class, 'mail-ComposeButton')]"));
        writeButton.click();

        return new SendMailForm(driver);
    }
}
