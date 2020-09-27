	package loginPage;

	import java.io.IOException;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	//import pageObject.ForgotPassword;
	import pageObject.LandingPage;
	import pageObject.LoginPage;
	import resources.baseURL;

	public class homepage extends baseURL{
		public WebDriver driver;
		
		
		public static Logger log=LogManager.getLogger(baseURL.class.getName());
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
		public void HPage2() throws IOException
		{
          LandingPage lp=new LandingPage(driver);
		
			lp.checklogin().click();		
			LoginPage l=new LoginPage(driver);
			l.getemail().sendKeys("ppp@kkk");
			log.info("usernameHP typed");
			l.getpassword().sendKeys("777");
			log.info("passwordHP typed");
			//log.info("password entered");
			l.gosign().click();
			log.info("sign in clicked");
			
			
						
		}
	@AfterTest
	public void finishoff() {
		
		driver.close();
		//driver=null;
		//driver.quit();
	}
		
	}



