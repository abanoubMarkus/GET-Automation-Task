package Tests;

import Base.BaseTest;
import Data.ExcelDataReader;
import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTests extends BaseTest {

    WebDriver driver = getDriver();
    HomePage hpObject = new HomePage();

    public String username = ExcelDataReader.GetDataFromExcel("Data/GetTaskExcel.xlsx",0,0,0);
    public String password = ExcelDataReader.GetDataFromExcel("Data/GetTaskExcel.xlsx",0,0,1);
    public String category = ExcelDataReader.GetDataFromExcel("Data/GetTaskExcel.xlsx",0,0,2);
    public String product = ExcelDataReader.GetDataFromExcel("Data/GetTaskExcel.xlsx",0,0,3);

    public HomePageTests() throws IOException {
    }


    @Test
    public void LoginTest(){
        hpObject.Login(username,password, driver);
        hpObject.CheckUser(username,driver);
    }

    @Test
    public void Search() throws InterruptedException {
        hpObject.ChooseCategory(category,driver);
        hpObject.ChooseProduct(product,driver);
    }


}
