package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;


public class BasePage {
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
    }

    public WebDriver driver;
    public WebDriverWait wait;

    public WebElement elementC(By Locator){
        wait.until(ExpectedConditions.elementToBeClickable(Locator));
        return driver.findElement(Locator);
    }

    public WebElement elementV(By Locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
        return driver.findElement(Locator);
    }

    public void elementI(By Locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(Locator));
    }

    public List<WebElement> elementsV(List<WebElement> elementList){
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return elementList;
    }
}

