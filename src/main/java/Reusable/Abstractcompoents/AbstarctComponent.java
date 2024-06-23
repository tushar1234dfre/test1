package Reusable.Abstractcompoents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstarctComponent {
	
	public WebDriver driver;
	
	
	
	public AbstarctComponent(WebDriver driver) {
		
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}

	

	
	//here we use Visibility of element located condition and pass the Locator as a argument
	public void waitForElementToAppear(By findBy){
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	//here we use visibilityof condition and pass the WebElement as a argument
    public void waitForWebElementToAppear(WebElement findBy) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void implicitwait(int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public void waitForElementTodisapper(WebElement ele) throws InterruptedException
	{
		Thread.sleep(5000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
//		
	}
	
	
	public void selectOptionFromDropdown(List<WebElement> options , String value)
	{
		for(WebElement option : options)
	    {
	    	
	    	if(option.getText().equals(value))
	    	{
	    		option.click();
	    		break;
	    	}
		
	    }
	}
	
	public void scrollThePage(int scrollVertical)
	{
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0, arguments[0])", scrollVertical);

	}
	
	public void selectClassDropdown(WebElement option,int i)
	{
		System.out.println("list in dropdown is: " + option.getText());
		Select select = new Select(option);
		select.selectByIndex(i);
	}
	
	public void selcetallCheckBoxes(List<WebElement>allCheckBoxess)
	{
		for(WebElement checkbox: allCheckBoxess)
		{
			checkbox.click();
		
			System.out.println("All checkboxes are selected :" +checkbox.isSelected() );
		}
	}
	
	public void closeDriver()
	{
		driver.quit();
	}
}
