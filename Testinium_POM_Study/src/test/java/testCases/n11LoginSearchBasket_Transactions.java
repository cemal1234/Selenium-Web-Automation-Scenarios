package testCases;

import com.opencsv.exceptions.CsvValidationException;
import listener.Listener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testCaseFunction.BasketPage;
import testCaseFunction.LoginPage;
import testCaseFunction.ProductPage;
import testCaseFunction.SearchAndSelect;
import utils.BaseTest;

import java.io.IOException;

@Listeners({Listener.class})
public class n11LoginSearchBasket_Transactions extends BaseTest {

    @Test
    public void AllTests() throws IOException, CsvValidationException, InterruptedException {

        // Trendyol sayfasina erişim ve login islemleri

        LoginPage loginPage = new LoginPage(driver);
        loginPage.closeFuncyBox();
        loginPage.loginTransaction();
        loginPage.loginCheck();

        // Kategoriye gidip random ürün seçilir.

        SearchAndSelect searchAndSelect = new SearchAndSelect(driver);
        searchAndSelect.searchCategory();
        searchAndSelect.categoryControl();
        searchAndSelect.productControl();

        // Ürün bilgileri csv dosyasina işlenir.
        ProductPage productPage = new ProductPage(driver);
        productPage.productInfoWrite();

        // Sepete ürün ekleme, artırma, silme işlemleri ve kontrolleri.
        BasketPage basketPage = new BasketPage(driver);
        basketPage.productAddBasket();
        basketPage.priceComparison();
        basketPage.plusProduct();
        basketPage.deleteProduct();
    }
}
