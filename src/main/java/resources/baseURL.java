package resources;


import java.io.File;
import java.io.FileInputStream;
	//import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

	public class baseURL {
		public static  WebDriver driver;
		public Properties prop= new Properties();
		
		
		
		public  WebDriver selectURL() throws IOException {
					
			//String path=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
			//System.out.println(path);
			//removing  hard code path	
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
			
			// FileInputStream fis=new FileInputStream("C:\\Users\\Kiran\\EndToEnd\\src\\main\\java\\resources\\data.properties");
			 prop.load(fis);
			 
		  String browsername=System.getProperty("Browser");
	     //String browsername=prop.getProperty("Browser");
			 
			 System.out.println(browsername);
			 
			 
			 
			 if(browsername.contains("chrome")) 
			 {
				String path1=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", path1);
				ChromeOptions option=new ChromeOptions();
			
				  if(browsername.contains("headless"))
						{
					  option.addArguments("headless");
					  
						}
				
				  driver= new ChromeDriver(option);
					
			 }
				
			  	 else if(browsername.equals("firefox"))
			 						{
				 					System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kiran\\OneDrive\\Documents\\Tools\\geckodriver.exe");
			     					driver= new FirefoxDriver();}
			 								else if(browsername.equals("ie"))
			 								{
			 									
			 									System.setProperty("webdriver.ie.driver", "C:\\Users\\Kiran\\OneDrive\\Documents\\Tools\\IEDriverServer.exe");
			 									driver = new InternetExplorerDriver();
			 									}
			 										else {System.out.println("no browser");}
			 
			 
			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
			 
			 return driver;
		}
		
		public String url() throws IOException
		{
			//FileInputStream fis=new FileInputStream("C:\\Users\\Kiran\\E2EProject\\src\\main\\java\\resources\\data.properties");
			//prop.load(fisnew);
			String urlname=prop.getProperty("URL");
			return urlname;
		}
		
		
		public  String getscreenshot(String testcaseName, WebDriver driver) throws IOException 
		{ 
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testcaseName +".png";
			FileUtils.copyFile(src, new File(destinationFile));
			return destinationFile;
			
			
		}
		
		}
	


