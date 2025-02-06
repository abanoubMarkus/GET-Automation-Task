package PageObjects;

import Base.BaseTest;
import Data.ExcelDataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class HomePage  {

         public static String productName1 ;
         public static String productPrice ;
         public static String productDesc ;



    public void Login(String username, String password, WebDriver driver){
        driver.get("https://www.demoblaze.com/index.html#");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        WebElement LoginButton = driver.findElement(By.xpath("//a[@id='login2']"));
        LoginButton.click();
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='loginusername']"));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='loginpassword']"));
        passwordField.sendKeys(password);
        WebElement SecondLoginButton = driver.findElement(By.xpath("//button[@onclick='logIn()']"));
        SecondLoginButton.click();
    }

    public void CheckUser(String username, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4)); // Wait for up to 10 seconds

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='nameofuser']")));
        WebElement NameOfUser = driver.findElement(By.xpath("//a[@id='nameofuser']"));
        String userName = "Welcome " + username;
        Assert.assertEquals(userName,NameOfUser.getText() );
    }

    public void ChooseCategory(String category, WebDriver driver){
        List<WebElement> categories = driver.findElements(By.xpath("//a[@id='itemc']"));
        for(WebElement cat : categories){
            if(cat.getText().equalsIgnoreCase(category)){
                cat.click();
            }
        }

    }



    public void ChooseProduct(String pro, WebDriver driver) throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(2));
        List<WebElement> cardTitle = driver.findElements(By.xpath("//h4[@class='card-title']"));
        for(int i = 0;i< cardTitle.size();i++){
            if(cardTitle.get(i).getText().equalsIgnoreCase(pro)){
                //---------------------
                    String xpath = String.format("(//h4[@class='card-title']//following-sibling::h5)[%d]",i + 1 );
                    productPrice  = driver.findElement(By.xpath(xpath)).getText();
                    productName1 = cardTitle.get(i).getText();
                    String xpath2 = String.format("(//h4[@class='card-title']//following-sibling::p)[%d]",i + 1 );
                    productDesc = driver.findElement(By.xpath(xpath2)).getText();

                System.out.println(productName1);
                System.out.println(productPrice);
                System.out.println(productDesc);
                //---------------------

                cardTitle.get(i).click();
            }
        }
    }

}
