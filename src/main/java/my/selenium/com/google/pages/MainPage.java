package my.selenium.com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultPageWithCalculator findCalculator() {
        findText("Калькулятор");
        return new ResultPageWithCalculator(driver);
    }

    private void findText(String text) {
        inputText(text);
        submitSearchButton();
    }

    private void inputText(String text) {
        WebElement searchInput = driver.findElement(By.xpath("//input[@class = \"gLFyf gsfi\"]"));
        searchInput.sendKeys(text);
    }

    private void submitSearchButton() {
        WebElement searchButton = driver.findElement(By.xpath("//input[@class = \"gNO89b\"][1]"));
        searchButton.submit();
    }
}
