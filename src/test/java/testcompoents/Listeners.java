package testcompoents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;

public class Listeners extends BaseClass implements ITestListener {
	
	ExtentTest test;
	
	//call this getReportObject() method from ExtentReporterNG class which returns the ExtentReports as object
	ExtentReports extent = ExtentReporterNG.getReportObject();
	
	public void onTestStart(ITestResult result) {   //ITestRuslt is a class which describes the result of test 
        // TODO Auto-generated method stub  
		
		// ExtentTest defines a test you can add logs ,snapshots assign to test and its children
	   test  =	extent.createTest(result.getMethod().getMethodName());
          
    }  
  
    public void onTestSuccess(ITestResult result) {  
        // TODO Auto-generated method stub  
        test.log(Status.PASS, result.getMethod().getMethodName());  
    }  
  
    public void onTestFailure(ITestResult result) {  
        // TODO Auto-generated method stub  
        System.out.println("Failure of test cases and its details are : "+result.getName());  
        test.fail(result.getThrowable());  //getThrowable() method throw the error of fail test cases while running
        
        try {
        	//this method give us the driver
        	//getTestClass() it return the class name from testng.xml file 
        	//getRealClass() it return the actual java class name
        	//getField("driver") it returns the Field object of this class specified by driver
        	
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {  //Exception is a parent class of all exceptions , it  is a generic exception , no matter what exception is there jsut print it
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //call this getScreenshot method from the base class
        String filepath = null;
        try {
			filepath  = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //addScreenCaptureFromPath it is a method use to add the screenshot in extent report
        test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName() );
    }  
  
    public void onTestSkipped(ITestResult result) {  
        // TODO Auto-generated method stub  
    	
        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.SKIP, "Test Skipped: " + result.getName());
    }  
  
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
        // TODO Auto-generated method stub  
        System.out.println("Failure of test cases and its details are : "+result.getName());  
    }  
  
    public void onStart(ITestContext context) {   
        // TODO Auto-generated method stub  
    	System.out.println("Methods start");
          
    }  
    
//     ITestContext
//    This class defines a test context which contains all the information for a given test run. 
//    Aninstance of this context is  passed to the test listeners so they can query information about their environment.
  
    public void onFinish(ITestContext context) {  
        // TODO Auto-generated method stub  
    	
    	extent.flush();
          
    }  
	
	

}
