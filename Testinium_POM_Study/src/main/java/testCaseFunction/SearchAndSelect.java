package testCaseFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BasePage;
import java.util.List;
import java.util.Random;

public class SearchAndSelect extends BasePage {
    public SearchAndSelect(WebDriver driver) {
        super(driver);
    }

    // Search Keys
    By searchbar            =   By.className("search-box");
    String computer         =   ("Bilgisayar");

    public void searchCategory(){
        elementV(searchbar).sendKeys(computer);
    }

    public List<WebElement> findCategory() {
        By mainCategory = By.xpath("//div[@class='suggestion-result']");
        By subCategory = By.xpath("//a[@class='suggestion']");
        return elementsV(driver.findElement(mainCategory).findElements(subCategory));
    }

    public void categoryControl(){
        System.out.println(computer + "Kategorisine Gidiliyor."+"\n");
        findCategory().get(0).click();
        System.out.println("Kategori Adi : " + driver.getTitle());
    }

    public List<WebElement> findProduct() {
        By mainProduct = By.xpath("//div[@class='prdct-cntnr-wrppr']");
        By subProduct = By.xpath("//div[@class='p-card-wrppr']");
        return elementsV(driver.findElement(mainProduct).findElements(subProduct));
    }

    public void productControl(){
        System.out.println("Random Urune Gidiliyor."+"\n");

        Random rr = new Random();
        int randomTab = rr.nextInt(findProduct().size());
        findProduct().get(randomTab).click();
        System.out.println("Random Urun Adi : " + driver.getTitle());
    }
}
