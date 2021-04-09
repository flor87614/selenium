package my.selenium;

import my.selenium.com.google.pages.MainPage;
import my.selenium.com.google.pages.ResultPageWithCalculator;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleCalculatorTest {
    private static WebDriver driver;
    private MainPage mainPage;

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Before
    public void setUp() {
        mainPage = new MainPage(driver);
        driver.get("http://google.com");
    }

    @Test
    public void testCorrectMathOperations() {
        ResultPageWithCalculator calculatorPage = mainPage.findCalculator();
        calculatorPage.inputCalcText("(1 + 2) * 3 - 40 / 5");
        Assert.assertEquals("(1 + 2) × 3 - 40 ÷ 5 =", calculatorPage.getMemoryText());
        Assert.assertEquals("1", calculatorPage.getResultText());
    }

    @Test
    public void testZeroDevide() {
        ResultPageWithCalculator calculatorPage = mainPage.findCalculator();
        calculatorPage.inputCalcText("6 / 0");
        Assert.assertEquals("6 ÷ 0 =", calculatorPage.getMemoryText());
        Assert.assertEquals("Infinity", calculatorPage.getResultText());
    }

    @Test
    public void testIncorrectSin() {
        ResultPageWithCalculator calculatorPage = mainPage.findCalculator();
        calculatorPage.inputCalcText("sin");
        Assert.assertEquals("sin() =", calculatorPage.getMemoryText());
        Assert.assertEquals("Error", calculatorPage.getResultText());
    }

    @AfterClass
    public static void finish() {
        driver.close();
    }
}
