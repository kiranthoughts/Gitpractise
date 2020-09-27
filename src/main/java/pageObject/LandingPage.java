package pageObject;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	public class LandingPage {

		
		public WebDriver driver;
		
		 By signin=By.linkText("Login");
		 By title=By.cssSelector(".text-center>h2");
		 By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
		
		
		
		
		
		public LandingPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			
			this.driver=driver;
			
		}




		public WebElement checklogin()
		{
			return driver.findElement(signin);
		}
		public WebElement getnavbar()
		{
			return driver.findElement(NavBar);
		}
		public WebElement message()
		{
			return driver.findElement(title);
		}
		
		
		
	}



