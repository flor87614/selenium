package my.selenium.ru.yandex.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendMailForm {
    private WebDriver driver;

    public SendMailForm(WebDriver driver) {
        this.driver = driver;
    }

    public MailPage sendMail(String subject, String address, String text) {
        WebElement addrInput = driver.findElement(By.xpath("//div[contains(@class, 'MultipleAddressesDesktop-Field')]//div[@contenteditable='true']"));
        addrInput.sendKeys(address);

        WebElement subjectInput = driver.findElement(By.xpath("//input[contains(@class, 'ComposeSubject-TextField')]"));
        subjectInput.sendKeys(subject);

        WebElement textBox = driver.findElement(By.xpath("//div[@role='textbox']"));
        textBox.sendKeys(text);

        WebElement sendButton = driver.findElement(By.xpath("//div[contains(@class, 'ComposeSendButton')]//button[@type='button']"));
        sendButton.click();

        return new MailPage(driver);
    }
}
