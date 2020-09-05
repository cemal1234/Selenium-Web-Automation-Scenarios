package testCaseFunction;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;
import org.testng.Assert;
import java.io.FileReader;
import java.io.IOException;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Pop-Up Keys
    By pop_up_close         =   By.className("fancybox-close");
    By pop_up_lost          =   By.className("fancybox-overlay");
    //Login Keys
    By login_button         =   By.id("accountBtn");
    By e_mail               =   By.id("email");
    By password             =   By.id("password");
    By enter_Site           =   By.id("loginSubmit");
    //Title Key
    String getTitle         =   ("En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da");
    //Account Keys
    By myaccount_Info       =   By.id("logged-in-container");
    String myaccountText    =   ("Hesabım");
    //User Pass Path
    String CSV_PATH_LOGIN   =   "D:/Users/admin/Desktop/Testinium_POM_Study/src/main/resources/loginInfo.csv";



    public void closeFuncyBox() {
        if (elementV(pop_up_close).isDisplayed()){
            elementC(pop_up_close).click();
            System.out.println("Cinsiyet Secim Ekrani Kapatiliyor...");
        }
        else {
            System.out.println("Cinsiyet Secim Ekrani Görüntülenmedi.");
        }

        elementI(pop_up_lost);
        Assert.assertEquals(getTitle,driver.getTitle());
        System.out.println("Anasayfa Görüntülendi."+"\n");
    }

    public void loginTransaction() throws IOException, CsvValidationException {
        System.out.println("Login Butonu Tiklaniyor..."+"\n");
        elementC(login_button).click();

        String[] csvCell;
        CSVReader csvReader = new CSVReader(new FileReader(CSV_PATH_LOGIN));
        csvCell = csvReader.readNext();

        String email = csvCell[0];
        String pass = csvCell[1];

        elementC(e_mail).sendKeys(email);
        elementC(password).sendKeys(pass);
        elementC(enter_Site).click();
        elementI(pop_up_lost);
    }

    public void loginCheck(){
        Assert.assertEquals(myaccountText, elementV(myaccount_Info).getText());
        System.out.println("Basariyla Login İslemi Gerceklesti.");
    }
}
