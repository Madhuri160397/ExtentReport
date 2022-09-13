package Reports.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class EReport {
	ExtentReports ExReport;
	@BeforeTest
	public void config() {
		
		//ExtentReport , ExtentSparkReporter
	    String path =	System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter ExSReport = new ExtentSparkReporter(path);
		ExSReport.config().setReportName("WebAutomationResult");
		ExSReport.config().setDocumentTitle("Test Result");
		
		ExtentReports ExReport = new ExtentReports();
		ExReport.attachReporter(ExSReport);
		ExReport.setSystemInfo("Tester", "Madhuri Borse");
	}

	@Test
	public void demo() {
		
		ExReport.createTest("initialize browser");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Setup\\Selenium Driverss\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		System.out.println(driver.getTitle());
		ExReport.flush();

	}

}
