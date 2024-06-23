package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	
	public static ExtentReports getReportObject()
	{
		// Two classes are important 1. ExtentReports , 2. ExtentSpartReporter
		
		String path = System.getProperty("user.dir")+ "\\reports\\Signin.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automatipn Practice Site");
		reporter.config().setDocumentTitle("Automation Result");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Tushar Phatangare");
		extent.setSystemInfo("Operating System", "Windows");
		
		
		return extent;
		
		
	}
	
	
}
