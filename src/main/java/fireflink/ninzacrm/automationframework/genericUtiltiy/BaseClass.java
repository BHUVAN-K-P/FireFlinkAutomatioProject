package fireflink.ninzacrm.automationframework.genericUtiltiy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepository.DashBoardPage;
import objectrepository.LoginPage;

public class BaseClass {

	public FileUtility fUtil=new FileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public WebDriver driver;
	
	public static WebDriver sdriver;
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("BD connection successfull");
	}
	@BeforeClass(alwaysRun = true)
//	@Parameters("browser")
//	@BeforeTest
	public void bcConfig(/*String BROWSER */) throws IOException {
		String BROWSER=fUtil.readDataFromPropertyFile("browser");
		String URL=fUtil.readDataFromPropertyFile("url");
		
		
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		//for listeners...
		sdriver=driver;
		wUtil.navigateUrl(driver, URL);
		wUtil.maximizeWindow(driver);
		
	}
	@BeforeMethod(alwaysRun = true)
	public void btConfig() throws IOException {
		LoginPage lp=new LoginPage(driver);
		String USERNAME=fUtil.readDataFromPropertyFile("username");
		String PASSWORD=fUtil.readDataFromPropertyFile("password");
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("login successfully");
	
	}
	@AfterMethod(alwaysRun = true)
	public void atConfig() {
		DashBoardPage db=new DashBoardPage(driver);
		db.loggingOut(driver);
		System.out.println("logout successfully...");
	}
	
	@AfterTest(alwaysRun = true)
	public void acConfig() {
		driver.quit();
		System.out.println("closing browser...");
	}
	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("BD connection closed");
	}
}
