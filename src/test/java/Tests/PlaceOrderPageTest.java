package Tests;

import Base.BaseTest;
import PageObjects.CartPage;
import PageObjects.PlaceOrderPage;
import PageObjects.productPage;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.io.IOException;

public class PlaceOrderPageTest extends BaseTest {
    public PlaceOrderPageTest() throws IOException {
    }


    CartPage cd = new CartPage();
    productPage ddd= new productPage();
    PlaceOrderPage pop = new PlaceOrderPage();

    @Test
    public void AddData() throws InterruptedException {
        ddd.proDetails(driver);
        ddd.AddToCart(driver);
        cd.CartItem(driver);
        pop.PlaceOrder(driver);
        pop.ConfMessage(driver);

    }

    @Test
    public void AssertConfMessage(){
        Assert.assertEquals(pop.amount.trim(),cd.cartPrice);
        try {

            takeScreenshotOnSuccess(driver, "screenshotLast.png");

        } catch (Exception e) {
            e.printStackTrace();


        }


    }

}
