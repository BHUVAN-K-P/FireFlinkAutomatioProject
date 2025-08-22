package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampgainPage {

	@FindBy(xpath="//input[@name=\"campaignName\"]")
	private WebElement CampgainName;
	
	@FindBy(xpath="//input[@name=\"targetSize\"]")
	private WebElement TargetSize;
	
	@FindBy(xpath="//button[text()=\"Create Campaign\"]")
	private WebElement createCampgainBtn;
	
	public CreateCampgainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampgainName() {
		return CampgainName;
	}


	public WebElement getTargetSize() {
		return TargetSize;
	}


	public WebElement getCreateCampgainBtn() {
		return createCampgainBtn;
	}

	public void createCampgain(String name,String tsize) {
		
		CampgainName.sendKeys(name);
		TargetSize.sendKeys(tsize);
		createCampgainBtn.click();
	}
	
	
}
