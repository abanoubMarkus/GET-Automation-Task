package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaceOrderPage {

    public String id;
    public String amount;
    public String cardNumber;
    public String name;
    public String date;




    public void PlaceOrder(WebDriver driver) throws InterruptedException {

        WebElement placeOrderButton = driver.findElement(By.xpath("//button[normalize-space()='Place Order']"));
        placeOrderButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='name']")));
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Abanoub");
        driver.findElement(By.xpath("//input[@id='country']")).sendKeys("Egypt");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Giza");
        driver.findElement(By.xpath("//input[@id='card']")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@id='month']")).sendKeys("December");
        driver.findElement(By.xpath("//input[@id='year']")).sendKeys("2000");
        driver.findElement(By.xpath("//button[normalize-space()='Purchase']")).click();
        //--------------------------------
        Thread.sleep(Duration.ofSeconds(2));
        System.out.println("------------dddddd");




    }

    private static String extractValue(String input, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        return matcher.find() ? matcher.group(1) : "Not found";
    }


    public void ConfMessage(WebDriver driver){
        WebElement message = driver.findElement(By.cssSelector(".lead.text-muted"));
        String AllValue = message.getText();

        Pattern idPattern = Pattern.compile("Id:\\s*(\\d+)");
        Pattern amountPattern = Pattern.compile("Amount:\\s*(\\d+\\s+)");
        Pattern cardPattern = Pattern.compile("Card Number:\\s*(\\d+)");
        Pattern namePattern = Pattern.compile("Name:\\s*(\\w+)");
        Pattern datePattern = Pattern.compile("Date:\\s*(\\d+/\\d+/\\d+)");
         id = extractValue(AllValue, idPattern);
         amount = extractValue(AllValue, amountPattern);
         cardNumber = extractValue(AllValue, cardPattern);
         name = extractValue(AllValue, namePattern);
         date = extractValue(AllValue, datePattern);




    }





}
