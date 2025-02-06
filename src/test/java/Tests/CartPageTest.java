package Tests;

import Base.BaseTest;
import PageObjects.CartPage;
import PageObjects.productPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CartPageTest extends BaseTest {
    public CartPageTest() throws IOException {
    }


    CartPage cd = new CartPage();
    productPage ddd= new productPage();



    @Test
    public void CartTest() throws InterruptedException {
        ddd.proDetails(driver);
        ddd.AddToCart(driver);
        cd.CartItem(driver);
        Assert.assertEquals(ddd.productNameFromPage, cd.cartTitle);

        String priceWithoutDollar = ddd.productPriceFromPage.replace("$","");
        Assert.assertEquals(priceWithoutDollar, cd.cartPrice);

    }
}
