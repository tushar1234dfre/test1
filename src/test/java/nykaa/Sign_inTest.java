package nykaa;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import locators.pageobjects.mobileauthenticationPage;
import testcompoents.BaseClass;

public class Sign_inTest extends BaseClass {
	
	public 	mobileauthenticationPage mobileauthenticationpage;
		
	@Test(priority = 1)
	public void verify_Signin_Button()
	{
		sin.cheksigninbutton();
		//throw new SkipException("Skipping the test");
	}
	
	@Test(priority = 2)
	public void verify_Login_Create_Account_Text()
	{
		
		String tabtext = sin.checktabheader();
		Assert.assertEquals(tabtext, "Login / Create Account");
	}
	
	
	@Test(priority = 3)
	public void verify_Register_Now_Text()
	{
	  String registertext =	sin.checktabheader1();
	  Assert.assertEquals(registertext,"Register now and get 2000 Nykaa reward points instantly!");
	}
	
	@Test(priority = 4)
	public void verify_Google_Button()
	{
		sin.checkGoogleButton();
	}
	
	@Test(priority=5)
	public void verify_Signin_with_google_email_Button()
	{
		sin.checksigninwithmobilebutton();
	}
	
	@Test(priority =6)
	public void verify_Common_Header()
	{
		mobileauthenticationpage =  new mobileauthenticationPage(driver);
		String loginRegisterText = mobileauthenticationpage.checkcommonheader();
		Assert.assertEquals(loginRegisterText, "LOGIN / REGISTER");
	}
	
	@Test(priority = 7)
	public void verify_mobile_Number_Input_Field()
	{
		String wrongmobileNumber = "8796500";
		String correctMobileNumber ="8796500457";
		
		mobileauthenticationpage.checkMobileNumberInputFiled(wrongmobileNumber,correctMobileNumber);
	}
	
	@Test(priority = 8)
	public void verify_Proceed_Button()
	{
		mobileauthenticationpage.checkProceedButton();
		
	}
	
	
}