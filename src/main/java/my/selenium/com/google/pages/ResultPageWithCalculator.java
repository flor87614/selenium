package my.selenium.com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPageWithCalculator extends ResultPage {
    public ResultPageWithCalculator(WebDriver driver) {
        super(driver);
    }

    public void inputCalcText(String text) {
        WebElement calcInput = driver.findElement(By.xpath("//div[@class = \"jlkklc\"]"));
        calcInput.sendKeys(text);
        calcInput.sendKeys(Keys.ENTER);
    }

    public String getMemoryText() {
        WebElement memorySpan = driver.findElement(By.xpath("//span[@class = \"vUGUtc\"]"));
        return memorySpan.getText();
    }

    public String getResultText() {
        WebElement resultSpan = driver.findElement(By.xpath("//span[@id = \"cwos\"]"));
        return resultSpan.getText();
    }
}
