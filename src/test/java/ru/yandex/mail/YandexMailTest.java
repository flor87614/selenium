package ru.yandex.mail;

import my.selenium.com.google.pages.MainPage;
import my.selenium.ru.yandex.mail.LoginPage;
import my.selenium.ru.yandex.mail.MailPage;
import my.selenium.ru.yandex.mail.SendMailForm;
import my.selenium.ru.yandex.mail.WelcomePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YandexMailTest {
    private WebDriver driver;
    private WelcomePage welcomePage;

    @BeforeClass
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Ann/chromedriver/chromedriver.exe");

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

        driver = new ChromeDriver(dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void setUp() {
        welcomePage = new WelcomePage(driver);
        driver.get("https://mail.yandex.ru");
    }

    @Test
    public void test() throws InterruptedException {
        LoginPage loginPage = welcomePage.enter();
        MailPage mailPage = loginPage.login("a.sheavdrov.simbirsoftSDET", "SDET12345");
        int mailsCount = mailPage.countMailsBySubject("Simbirsoft theme");

        SendMailForm sendMailForm = mailPage.createMail();
        mailPage = sendMailForm.sendMail("Simbirsoft theme", "a.sheavdrov.simbirsoftSDET@yandex.ru", String.valueOf(mailsCount));

        Thread.sleep(5000);
        driver.navigate().refresh();

        Assert.assertEquals(mailPage.countMailsBySubject("Simbirsoft theme"), mailsCount + 1);
    }
}
