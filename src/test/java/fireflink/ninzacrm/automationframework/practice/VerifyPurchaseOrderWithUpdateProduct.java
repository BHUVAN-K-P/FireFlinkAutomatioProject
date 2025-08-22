package fireflink.ninzacrm.automationframework.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyPurchaseOrderWithUpdateProduct {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String browser=pobj.getProperty("browser");
		String url=pobj.getProperty("url");
		String username=pobj.getProperty("username");
		String password=pobj.getProperty("password");
		WebDriver driver=null;
		
		WebDriverManager.edgedriver().setup();
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}else {
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign In']")).submit();
		
		
		driver.findElement(By.linkText("Contacts")).click();
		Actions actions=new Actions(driver);
		
		WebElement create=driver.findElement(By.xpath("//span[text()='Create Contact']"));
		actions.click(create).perform();
		
		Random random=new Random();
		int randomNum=random.nextInt(1000);
		
		FileInputStream fis1=new FileInputStream("src\\test\\resources\\testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("Sheet2");
		Row r=sh.getRow(1);
		Cell c=r.getCell(0);
		String cName=c.getStringCellValue();
		String orgName=r.getCell(1).getStringCellValue()+randomNum;
		String mobile=r.getCell(2).getStringCellValue();
		String title=r.getCell(3).getStringCellValue();
		String email=randomNum+r.getCell(4).getStringCellValue();
		String dept=r.getCell(5).getStringCellValue();
		String officePhon=r.getCell(5).getStringCellValue();
		String quantity=r.getCell(6).getStringCellValue();
		String prodName=r.getCell(7).getStringCellValue();
		String pricePerUnit=r.getCell(7).getStringCellValue();

		wb.close();	
		
		WebElement e1=driver.findElement(By.xpath("//input[@name=\"contactName\"]"));
		actions.sendKeys(e1,cName).perform();
		
		 e1=driver.findElement(By.xpath("//input[@name=\"organizationName\"]"));
		actions.sendKeys(e1,orgName).perform();
		
		
		 e1=driver.findElement(By.xpath("//input[@name=\"mobile\"]"));
		actions.sendKeys(e1,mobile).perform();
			
		 e1=driver.findElement(By.xpath("//input[@name=\"title\"]"));
		actions.sendKeys(e1,title).perform();
		
		e1=driver.findElement(By.xpath("//input[@name=\"email\"]"));
		actions.sendKeys(e1,email).perform();	
				
		e1=driver.findElement(By.xpath("//input[@name=\"department\"]"));
		actions.sendKeys(e1,dept).perform();
		driver.findElement(By.xpath("//*[local-name()='svg']/parent::button")).click();		
		Set<String> elements=driver.getWindowHandles();
		String main=driver.getWindowHandle();
		for(String s:elements) {
			if(!s.equals(driver.getWindowHandle())) {
				driver.switchTo().window(s);
				break;
			}
		}
		driver.findElement(By.xpath("//button[@onclick=\"selectCampaign('CAM00002', 'Roshal')\"]")).click();
		driver.switchTo().window(main);
		actions.scrollByAmount(0,200).perform();
		e1=driver.findElement(By.xpath("//input[@name=\"officePhone\"]"));
		actions.sendKeys(e1,officePhon).perform();
		
		driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
		
		driver.findElement(By.linkText("Products")).click();
		WebElement product=driver.findElement(By.xpath("//span[text()='Add Product']"));
		actions.click(product).perform();
		WebElement prod=driver.findElement(By.xpath("//input[@name='quantity']"));
		prod.clear();
		actions.sendKeys("4").perform();
		driver.findElement(By.name("productName")).sendKeys("bulb");
		
		WebElement price=driver.findElement(By.name("price"));
		price.clear();
		actions.sendKeys("10").perform();
		
		
		WebElement category=driver.findElement(By.xpath("//select[@name='productCategory']"));
		Select select1=new Select(category);
		select1.selectByVisibleText("Electricals");
		
		WebElement vendor=driver.findElement(By.xpath("//select[@name='productCategory']"));
		Select select2=new Select(vendor);
		select1.selectByVisibleText("VID_001");
		
		
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		//VID_001
		
	}
}
