package PageObjects;

import Base.BaseTest;
import Tests.HomePageTests;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class productPage {
    public productPage() throws IOException {
    }



    HomePageTests dd = new HomePageTests();
    HomePage ss = new HomePage();

    public String productNameFromPage;
    public String productPriceFromPage;
    public String productDescFromPage;



    public void proDetails(WebDriver driver) throws InterruptedException {

        ss.Login(dd.username,dd.password,driver);
        ss.CheckUser(dd.username, driver);
        ss.ChooseCategory(dd.category,driver);
        ss.ChooseProduct(dd.product, driver);
        productNameFromPage = driver.findElement(By.cssSelector(".name")).getText();
        System.out.println(productNameFromPage);
        productPriceFromPage = driver.findElement(By.xpath("//h3[@class='price-container']")).getText().split(" ")[0];
        System.out.println(productPriceFromPage);
        productDescFromPage = driver.findElement(By.xpath("//div[@id='more-information']//p")).getText();
        System.out.println(productDescFromPage);


    }

    public void AddToCart(WebDriver driver) throws InterruptedException {

        WebElement AddToCartButton = driver.findElement(By.xpath("//a[normalize-space()='Add to cart']"));
        AddToCartButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }



}
