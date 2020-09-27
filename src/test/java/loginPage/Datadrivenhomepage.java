package loginPage;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import pageObject.ForgotPasswordPage;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.baseURL;

public class Datadrivenhomepage extends baseURL{
	public WebDriver driver;
	@BeforeMethod()
	public void starter() throws IOException {
		driver = selectURL();
		System.out.println(driver);
		log.info("browser opened");
		driver.get(url());
		log.info("url clicked");
		driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();	
		log.info("popup closed");
		
	}
	
	
	public static Logger log=LogManager.getLogger(baseURL.class.getName());
	@Test (dataProvider="getdata")
	public void HPage1(String Username, String password) throws IOException
	{
		
		
		//System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		
		LandingPage lp=new LandingPage(driver);
		
		//driver.switchTo().alert().dismiss();
		lp.checklogin().click();
		log.info("login clicked");
		LoginPage l=new LoginPage(driver);
		l.getemail().sendKeys(Username);
		log.info("username typed");
		
		l.getpassword().sendKeys(password);
		log.info("password typed");
		l.gosign().click();
		log.info("invalid customer");
		/*l.fpassword().click();
		ForgotPasswordPage  fp=new ForgotPasswordPage(driver);
		fp.resetemail().sendKeys(resetpassword);*/
		
		//driver=null;
		
	}
	
	@AfterMethod()
	public void finishoff() {
		
		driver.close();
		//driver=null;
		//driver.quit();
	}
	
	
	
			
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data= new Object[3][2];
		data [0][0]="abc@def";
		data [0][1]="123";
		data [1][0]="ghi@jkl";
		data [1][1]="456";
		data [2][0]="mno@pqr";
		data [2][1]="789";
		
		return data;
	}
}
