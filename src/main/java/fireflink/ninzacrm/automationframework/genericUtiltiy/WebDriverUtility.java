package fireflink.ninzacrm.automationframework.genericUtiltiy;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *  This class consists of generic methods related to WebDriver
 * @author Bhuvan K P
 *
 */
public class WebDriverUtility {
	//maximize,minimize,fullscreen
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will fullscreen the window
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	
	public void navigateUrl(WebDriver driver,String url) {
		driver.get(url);
	}
	/**
	 * This method will implicitly wait
	 * @param driver
	 */
	public void implicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will explicitly wait untill element is visible
	 * @param wait
	 * @param e
	 */
	public void waitTillWebElementToBeVisible(WebDriverWait wait,WebElement e) {
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	/**
	 * This method will explicitly wait untill element is clickable
	 * @param wait
	 * @param e
	 */
	public void waitTillWebElementToBeClickable(WebDriverWait wait,WebElement e) {
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	/**
	 * This method will select the dropdown based on index
	 * @param element
	 */
	public void dropDownHandle(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * This method will select the dropdown based on value
	 * @param element
	 * @param value
	 */
	public void dropDownHandle(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 *  This method will select the dropdown based on value
	 * @param visibleText
	 * @param element
	 */
	public void dropDownHandle(String visibleText,WebElement element) {
		Select select=new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	
	//Action class-mouse overing,drag and drop,click n hold,release,move by offset,double click,context click
	/**
	 * This will move the mouse to specified webelement
	 * @param driver
	 * @param element
	 */
	public void mouseHoveringAction(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element);
	}
	
	/**
	 * This method will move the mouse to specified webelement at specified position
	 * @param driver
	 * @param element
	 * @param xcord
	 * @param ycord
	 */
	public void mouseHoveringAction(WebDriver driver,WebElement element,int xcord,int ycord) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element,xcord,ycord).perform();;
	}
	/**
	 * This method will perform drag and drop operation from source to target
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement target) {
		Actions actions=new Actions(driver);
		actions.dragAndDrop(src, target).perform();
	}
	
	/**
	 * This method will perform drag and drop opertaion from source to specified position
	 * @param driver
	 * @param src
	 * @param xoffset
	 * @param yoffset
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,int xoffset,int yoffset) {
		Actions actions=new Actions(driver);
		actions.dragAndDropBy(src, xoffset, yoffset).perform();
	}
	
	/**
	 * This method will perform click and hold then release actions on specific webElement
	 * @param driver
	 * @param element
	 */
	public void clickNHoldNRelease(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.clickAndHold(element).release().perform();
	}
	
	/**
	 * This method move the cursor to specified point
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void moveByOffset(WebDriver driver,int x,int y) {
		Actions actions=new Actions(driver);
		actions.moveByOffset(x, y).perform();

	}
	
	/**
	 * This method perform double click action on the specific webelement
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	/**
	 * This method perform rigth click action on the specific webelement
	 * @param driver
	 * @param element
	 */
	public void contextClick(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	/**
	 * This method will switch to frame based on index of the frame
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method will switch to frame based on Webelemnt of the frame
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method will switch to frame based on frame name or id 
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver,String index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method will switch to its parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
		
	}
	/**
	 * This method will switch default content
	 * @param driver
	 */
	public void switchToDefaultContentt(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	//alert
	
	public void switchToAlertToAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertToReject(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToAlertToSendInput(WebDriver driver,String input) {
		driver.switchTo().alert().sendKeys(input);
	}
	
	public void switchToOtherWindow(WebDriver driver) {
		String main=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String s:windows) {
			if(!s.equals(main)) {
				driver.switchTo().window(s);
				break;
			}
		}
	}
	
	
	/*
	 * This method will capture the screenshot and return
	 * the path to caller
	 * @param driver
	 * @param ScreenshotName
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\ScreenShot\\"+screenShotName+".png");
		
		FileHandler.copy(src, dest);
		
		return dest.getAbsolutePath(); //extent reports
	}
}
