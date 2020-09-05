package testCaseFunction;

import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    //Products Info
    String product_name        =    driver.findElement(By.className("pr-in-nm")).getText();
    String product_amount      =    driver.findElement(By.xpath("//div[@class='pr-in-cn']//span[contains(@class,'prc-slg')]")).getText();
    //Product Write Path
    String CSV_PATH_PRODUCT    =    "D:/Users/admin/Desktop/Testinium_POM_Study/src/main/resources/productInfo.csv";

    public void productInfoWrite() throws IOException {
        System.out.println("Urun Bilgileri Dosyaya İsleniyor."+"\n");

        PrintWriter printWriter = new PrintWriter(new FileWriter(CSV_PATH_PRODUCT));
        CSVWriter writecsv = new CSVWriter(new FileWriter(CSV_PATH_PRODUCT));
        writecsv.writeNext(new String[]{product_amount});
        printWriter.println();
        writecsv.writeNext(new String[]{product_name});
        writecsv.close();

        System.out.println("Urun Adi: " + product_name);
        System.out.println("Urun Fiyati: " + product_amount + "\n");

    }
}
