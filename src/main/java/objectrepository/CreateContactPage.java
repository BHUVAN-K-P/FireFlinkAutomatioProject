package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fireflink.ninzacrm.automationframework.genericUtiltiy.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {
	
	@FindBy(xpath = "//input[@name='contactName']")
	private WebElement 	contactNameTF;
	@FindBy(xpath = "//input[@name='organizationName']")
	private WebElement organizationTF;
	
	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement mobileTF;
	@FindBy(xpath = "//input[@name='title']")
	private WebElement titleTF;
	@FindBy(xpath = "//input[@style=\"flex: 1 1 0%; margin-right: 10px;\"]")
	private WebElement campgainTF;
	@FindBy(xpath = "//button[text()='Create Contact']")
	private WebElement createContactBtn;
	
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactNameTF() {
		return contactNameTF;
	}


	public WebElement getOrganizationTF() {
		return organizationTF;
	}


	public WebElement getMobileTF() {
		return mobileTF;
	}


	public WebElement getTitleTF() {
		return titleTF;
	}


	public WebElement getCampgainTF() {
		return campgainTF;
	}


	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

 public void createContact(String contactname,String orgname,String mobile,String title,String campgain,WebDriver driver) {
	 ContactPage cp=new ContactPage(driver);
	 cp.getCreateContact().click();
	 contactNameTF.sendKeys(contactname);
	 organizationTF.sendKeys(orgname);
	 mobileTF.sendKeys(mobile);
	 titleTF.sendKeys(title);
	 campgainTF.sendKeys(campgain);
	 createContactBtn.click();
 }
}
