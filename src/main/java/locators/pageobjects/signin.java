package locators.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Reusable.Abstractcompoents.AbstarctComponent;

public class signin extends AbstarctComponent{
	
	
	public WebDriver driver;
	
	public signin(WebDriver driver)
	{
	    super(driver);
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
	
	//.............................Home page....................................//
	
	@FindBy(xpath ="//*[text()='Sign in']")
	WebElement signinButton;	
	
	@FindBy(xpath ="//*[text()='Login / Create Account']")
	WebElement loginCreateAccountText;
	
	@FindBy(xpath ="//div[@class='css-6sbkyl']")
	WebElement registerNowText;
	
	@FindBy(xpath ="//div[@class='css-mko3lk']/button[1]")
	WebElement signinWithMobileButton;
	
	@FindBy(xpath ="//div[@class='css-mko3lk']/button[2]")
	WebElement  googlebutton;
	
	@FindBy(xpath = "(//div[@class='css-w2pv0j'])[1]")
	WebElement mobileemailButtonArrow;
	
	@FindBy(xpath ="(//div[@class='css-w2pv0j'])[2]")
	WebElement googleButtonArrow;
	
	
	public void gotourl()
	{
		driver.get("https://www.nykaa.com/");
	}
	
	public void cheksigninbutton()
	{
		System.out.println("Sign in button is displayed : "+ signinButton.isDisplayed());
		signinButton.click();
	
	}
	
	public String checktabheader()
	{
		System.out.println("Login/create account text is displayed : " + loginCreateAccountText.isDisplayed());
		
		String logintext = loginCreateAccountText.getText();
		System.out.println("login account text is : " + logintext);
		return logintext;
	}
	
	public String checktabheader1()
	{
		System.out.println("Reguster now text is displayed : " + registerNowText.isDisplayed());
		String registernowtext = registerNowText.getText();
		System.out.println("Register now text is : " + registernowtext) ;
		return registernowtext;
	}
	
	public void checkGoogleButton()
	{
		System.out.println("Google button tab is dispalyed : " + googlebutton.isDisplayed());
		System.out.println("Google button tab is dispalyed : " + googleButtonArrow.isDisplayed());
	}
	
	
	public void checksigninwithmobilebutton()
	{
		System.out.println("Sign in with Mobile/Email button is dispalyed : " + signinWithMobileButton.isDisplayed());
		System.out.println("Sign in with Mobile/Email arrow is dispalyed : " + mobileemailButtonArrow.isDisplayed());
		signinWithMobileButton.click();
		
	}
	
	

	
	
	
	

}
