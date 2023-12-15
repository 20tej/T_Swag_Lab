package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager
{
	static ExtentReports report;
	public static ExtentReports getReportInstance()
	{
		if(report==null)
		{
			String reportName = new SimpleDateFormat("dd-MM-YYYY").format(new Date());
			String NewReportName = "report "+reportName+".html";
			ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("F:\\Automation\\SeleniumPractice\\Tej_Sel_Framework\\ExtentReports\\"+NewReportName);
			report=new ExtentReports(); 
			report.attachReporter(htmlReporter); 
			report.setSystemInfo("OS","Windows");
			report.setSystemInfo("Environment","SIT");
			report.setSystemInfo("Build Number","102.02.02.126");
			report.setSystemInfo("Browser","chrome"); 
			htmlReporter.config().setDocumentTitle("UI Testing Documents"); 
			htmlReporter.config().setReportName("UI Test Report");
		}
			return report;	
	}

}
