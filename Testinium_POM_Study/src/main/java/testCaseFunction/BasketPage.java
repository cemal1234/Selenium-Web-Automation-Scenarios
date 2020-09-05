package testCaseFunction;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.BasePage;
import java.io.FileReader;
import java.io.IOException;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    //Basket Keys
    By addtoBasket           =  By.xpath("//div[@class='add-to-bs-tx'][contains(.,'Sepete Ekle')]");
    By addedtoBasket         =  By.className("pr-in-btn add-to-bs success");
    By myBasket              =  By.xpath("//div[@class='nav-span'][contains(.,'Sepetim')]");
    By summaryPrice          =  By.className("total-price");
    String getBasketTitle    =  ("Sepetim - Trendyol");
    By productName           =  By.className("pr-in-nm");
    By etbisDisplayed        =  By.id("ETBIS");

    //Product Increase and Delete Keys
    By plusButton            =  By.xpath("//button[@class='ty-numeric-counter-button']");
    By myTotalProduct        =  By.xpath("//div[@class='pb-header']");
    By productDelete         =  By.className("i-trash");
    By deleteApprove         =  By.xpath("//button[@class='btn-item btn-remove']/span[contains(.,'Sil')]");
    By emptyBasket           =  By.xpath("//span[contains(.,'Sepetinizde ürün bulunmamaktadır.')]");

    //Product Info PATH
    String CSV_PATH_PRODUCT  =  "D:/Users/admin/Desktop/Testinium_POM_Study/src/main/resources/productInfo.csv";

    public void productAddBasket() {
        System.out.println("Urun Sepete Ekleniyor." + "\n");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        elementV(etbisDisplayed);
        elementC(addtoBasket).click();
        elementI(addedtoBasket);

        System.out.println("Urun Sepete Basariyla Eklendi."+"\n");
        elementC(myBasket).click();
        elementI(productName);
        Assert.assertEquals(getBasketTitle, driver.getTitle());

    }

    public void priceComparison() throws IOException, CsvValidationException {
        String sPrice = elementV(summaryPrice).getText();

        String[] csvCell;
        CSVReader csvReader = new CSVReader(new FileReader(CSV_PATH_PRODUCT));
        csvCell = csvReader.readNext();

        String productPrice = csvCell[0];

        Assert.assertEquals(sPrice,productPrice);
        System.out.println("Ürün Sayfasindaki Fiyati: " + productPrice);
        System.out.println("Sepet Sayfasindaki Fiyati: " + sPrice+"\n");
    }

    public void plusProduct() throws InterruptedException {
        System.out.println("1 Urun Daha Ekleniyor."+"\n");
        elementC(plusButton).click();

        elementV(myTotalProduct);
        Thread.sleep(3000);

        String myTotalProductText = elementV(myTotalProduct).getText();

        Assert.assertEquals("Sepetim (2 Ürün)\n" +
                "Alışverişe Devam Et",myTotalProductText);
        System.out.println("Sepetimde 2 Adet Ürün Var."+"\n");

    }

    public void deleteProduct(){
        System.out.println("Sepetteki Ürün Siliniyor."+"\n");

        elementC(productDelete).click();
        elementC(deleteApprove).click();

        String emptyBasketText = elementV(emptyBasket).getText();

        Assert.assertEquals("Sepetinizde ürün bulunmamaktadır.",emptyBasketText);
        System.out.println("Sepetin Boş Olduğu Teyit Edildi."+"\n");
        System.out.println("Test Başarıyla Tamamlandi."+"\n");

    }
}
