package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	
WebDriver driver;
	
	private By resetid=By.id("user_email");
	
	public ForgotPasswordPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	
	}
	
		
	public WebElement resetemail()
	{
		return driver.findElement(resetid);
	}
	

}
