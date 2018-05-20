package CommanLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrangeHRM {
	
	public boolean LoginOrangeHRM (WebDriver d, String UserName, String Password)
	{
		try
		{
			System.out.println("LoginOrangeHRM"+super.getClass());
			d.findElement(By.id("txtUsername")).sendKeys(UserName);
			d.findElement(By.id("txtPassword")).sendKeys(Password);
			d.findElement(By.id("btnLogin")).click();
			System.out.println("Login Successful");
			return true;
			
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
	}

}
