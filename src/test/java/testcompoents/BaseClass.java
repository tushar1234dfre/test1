package testcompoents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import locators.pageobjects.signin;

public class BaseClass {
	
	public static  WebDriver driver;
	public static ExtentSparkReporter reporter;
	public static  ExtentReports extent;
	public static ExtentTest node;
	public static signin sin;
	
	public WebDriver initializeDriver() throws IOException
	{
		//Properties class in java which is use to extract the global value from .properties file
		Properties prop = new Properties();
		
		//Convert file into inputStream object by using FileInputStream class
		//"user.dir" is provide a default path up to project level
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\GlobalData.properties");
		
	    // load method load the file specified by the file argument
		//load method require inputstream object as a argument i.e fis
		prop.load(fis);
 
		// here System.getProperty("browser") use to set the system level variable values(browser value from system level i.e from maven)
		//and if this is no null then then take the browser property from sys variable ie from maven and if this is null then use browser value from global data .properties file
		//prop.getProperty("browser")
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		
		//Extract browser value from properties file
	    //String browserName = prop.getProperty("browser");
		
	    if(browserName.equalsIgnoreCase("chrome"))
	    {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	     }
	    
	    
	    //To run the tests in headless mode
//	    if(browserName.contains("headless"))
//	    {
//		ChromeOptions options = new ChromeOptions();
//	    options.addArguments("--headless");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver(options);
//		
//     }
	    
	    
	    else if(browserName.equalsIgnoreCase("firefox"))
	    {
	    	//Firefox
	    	WebDriverManager.firefoxdriver().setup();
	    	driver = new FirefoxDriver();
	    	
	    }
	    else if(browserName.equalsIgnoreCase("edge"))
	    {
	    	//Edge
	    	WebDriverManager.edgedriver().setup();
	    	driver = new EdgeDriver();
	    	
	    }
	    
	    //This to methods are common for all WebDrivers
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	driver.manage().window().maximize();
    	
        return driver;

}
	 public String getScreenshot(String testCaseName , WebDriver driver) throws IOException
     {
     	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     	String pngPath = System.getProperty("user.dir")+"\\reports\\" + testCaseName + ".png";
     	FileUtils.copyFile(src, new File(pngPath));
     	
     	return pngPath;
     }

	
	 @BeforeTest
	
    public signin  launchApplication() throws IOException
	{
		//provide life of this driver we call initializeDriver() method which return the WebDriver as a object
		
		 driver = initializeDriver();
		 
		 sin = new signin(driver);
		 sin.gotourl();
		 
		return sin;
		
	}
	
	//@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	


}
