package Tests;

import Base.BaseTest;
import PageObjects.HomePage;
import PageObjects.productPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class productPageTest extends BaseTest {
    public productPageTest() throws IOException {
    }


    productPage proPageObject = new productPage();



    @Test
    public void CompareProductDetails() throws InterruptedException {
        proPageObject.proDetails(driver);
        Assert.assertEquals(proPageObject.productNameFromPage, HomePage.productName1);
        Assert.assertEquals(proPageObject.productPriceFromPage, HomePage.productPrice);
        Assert.assertEquals(proPageObject.productDescFromPage, HomePage.productDesc);
        proPageObject.AddToCart(driver);
    }


}
