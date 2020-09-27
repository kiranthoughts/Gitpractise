package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//rahulonlinetutor@gmail.com
public class LoginPage {

	
	public  WebDriver driver;
	
	 private By  email=By.xpath("//input[@id='user_email']");
	 private By password=By.cssSelector("[type='password']");
	 private By login=By.cssSelector("[value='Log In']");
	 private By fpwd=By.xpath("//a[@class='link-below-button']");
	
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}




	public WebElement getemail()
	{
		return driver.findElement(email);
	}
	

	public WebElement getpassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement gosign()
	{
		return driver.findElement(login);
	}
	
	public WebElement fpassword()
	{
		return driver.findElement(fpwd);
	}
	
}

