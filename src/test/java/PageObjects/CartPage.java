package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    public String cartTitle;
    public String cartPrice;

    public void CartItem(WebDriver driver){

        WebElement CartPageButton = driver.findElement(By.xpath("//a[normalize-space()='Cart']"));
        CartPageButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='success']")));
        cartTitle = driver.findElement(By.xpath("(//tr[@class='success']//td)[2]")).getText();
        System.out.println(cartTitle);
        cartPrice = driver.findElement(By.xpath("(//tr[@class='success']//td)[3]")).getText();
        System.out.println(cartPrice);


    }


}
