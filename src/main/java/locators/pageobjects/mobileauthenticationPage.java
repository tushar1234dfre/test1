package locators.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Reusable.Abstractcompoents.AbstarctComponent;

public class mobileauthenticationPage  extends AbstarctComponent{
	
	public WebDriver driver;
	
	public mobileauthenticationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath ="//button[@class='close-btn']")
	WebElement closebutton;
	
	@FindBy(css ="header.common-header")
	WebElement loginRegistertext;
	
	@FindBy(xpath ="//*[@name='emailMobile']")
	WebElement mobileInputfield;
	
	@FindBy(xpath = "//span[text()='Required']")
	WebElement requiredLabel;
	
	@FindBy(xpath = "//span[text()='Enter a valid mobile number']")
	WebElement enterValidmobilenumberlabel;
	
	@FindBy(xpath ="//div[@class='clearfix wrapper-parent']")
	WebElement wrapper;
	
	@FindBy(id ="submitVerification")
	static WebElement proceedButton;
	
	
	
	public String checkcommonheader()
	{
		boolean clsbutton  = closebutton.isDisplayed();
		System.out.println("Close button symbol is displayed : " + clsbutton);
		
		System.out.println("Login/Register Text is dispalyed : " + loginRegistertext.isDisplayed());
		
		String loginregister = loginRegistertext.getText();
		System.out.println("Login register Text is : " + loginregister);
		
		return loginregister;
	}

	public void checkMobileNumberInputFiled(String wrongmobileNumber,String correctMobileNumber)
	{
		System.out.println("Enter Mobile number input field is displayed : " + mobileInputfield.isDisplayed());
		
		mobileInputfield.click();
		wrapper.click();
		
		System.out.println("Required label is dispalyed before entering the mobile number :" + requiredLabel.isDisplayed());
		System.out.println("Text of reqiured label is : " + requiredLabel.getText());
		
		mobileInputfield.sendKeys(wrongmobileNumber);

		System.out.println("Enter a valid mobile number label is dispalyed : " + enterValidmobilenumberlabel.isDisplayed());
		System.out.println("Text of Enter valid mobile number label is : " + enterValidmobilenumberlabel.getText());
		
		// Delete the entered numbers from input field
		mobileInputfield.sendKeys(Keys.CONTROL + "a");
		mobileInputfield.sendKeys(Keys.DELETE);
		
		mobileInputfield.sendKeys(correctMobileNumber);

	}
	
	public void checkProceedButton()
	{
		System.out.println("proceed Button is dispalyed : " + proceedButton.isDisplayed());
		System.out.println("Texxt of the proceed button is : " + proceedButton.getText());
		proceedButton.click();
		
	}
	
		
}
