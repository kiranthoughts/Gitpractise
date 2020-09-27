package loginPage;

//import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObject.LandingPage;
//import pageObject.LoginPage;
import resources.baseURL;

public class valnavbar extends baseURL{
	public WebDriver driver;
	
	
	public static Logger log =  LogManager.getLogger(baseURL.class.getName());
	@BeforeMethod
	public void starter() throws IOException {
		driver = selectURL();
		System.out.println(driver);
		log.info("browser opened");
		driver.get(url());
		log.info("url clicked");
		driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();	
		log.info("popup closed");
	}

	
	
	
	
	@Test
	public void HPage3() throws IOException
	{
						
		
		LandingPage lp=new LandingPage(driver);
		Assert.assertTrue(lp.getnavbar().isDisplayed());
		log.info("navigation bar displayed");
		
						
	}
	@AfterTest
	public void finishoff() {
		
		driver.close();
		//driver=null;
		//driver.quit();
	}
		

}
