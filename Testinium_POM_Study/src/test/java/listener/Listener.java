package listener;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.BaseTest;

import java.util.concurrent.TimeUnit;

public class Listener extends BaseTest implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {
        driver.get(baseUrl);
        log.info("https://www.trendyol.com Sayfası Açıldı.");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test Success");
        log.info("Test Başarılı");
    }
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test Failed");
        log.error("Test Hatalı");
    }
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test Skipped");
        log.warn("Test Atlandı");
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }
    public void onStart(ITestContext iTestContext) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium Drivers\\chromedriver.exe");
        driver =new ChromeDriver();
        log.info("Browser Açıldı.");
    }
    public void onFinish(ITestContext iTestContext) {
        driver.quit();
        log.info("Browser Kapatıldı.");
    }
}
