package ControlHandling_ComboBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import CommanLibrary.OrangeHRM;
import CommanLibrary.SelectCombboxValue;

public class ComboBoxEx_OrangeHRM {

public static void main(String [] args) throws InterruptedException {
	OrangeHRM or = new OrangeHRM();
	String UserName = "Admin";
	String Password = "admin";
	String UserRole = "ESS";
	
	System.setProperty("webdriver.chrome.driver","/Users/pranavdamele/Downloads/misc/chromedriver");
	WebDriver driver = new ChromeDriver();
	String currentWindow = driver.getWindowHandle();
    driver.switchTo().window(currentWindow);
	driver.get("http://opensource.demo.orangehrmlive.com/");
	if(or.LoginOrangeHRM(driver, UserName, Password))
	{
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		Thread.sleep(5000);
		if(new SelectCombboxValue(driver,By.id("searchSystemUser_userType")).SelectComboboxOption(UserRole,true))
		{
			driver.findElement(By.id("searchBtn")).click();
			int count_TotalRowsinTable=driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr")).size();
			////*[@id="resultTable"]/thead/tr
			int count_RowsBasedonCondition=driver.findElements(By.xpath("//*[@id='resultTable']/tbody/descendant::td[.='"+UserRole+"']/parent::tr")).size();
			if(count_TotalRowsinTable==count_RowsBasedonCondition)
			{
				System.out.println("Test case is PASSED, yadapdooo");
			}else
			{
				System.out.println("Test case is failed, duh!");
			}
		}else
		{
			System.out.println("Test case is failed, duh!");
		}
	}
	
	
}
	
}
