package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

	@FindBy(xpath = "//a[text()='Campaigns']")
	private WebElement CampgainLink;

	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement ContactLink;
	
	@FindBy(xpath = "//a[text()='Leads']")
	private WebElement LeadsLink;
	
	@FindBy(xpath = "//a[text()='Purchase Order']")
	private WebElement PurchaseOrderLink;
	
	//Products
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement ProductLink;
	
	@FindBy(xpath = "//*[local-name()='svg']/parent::div")
	private WebElement AdminImage;
	
	@FindBy(xpath = "//div[text()='Logout ']")
	private WebElement logout;
	
	public  DashBoardPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public WebElement getCampgainLink() {
		return CampgainLink;
	}


	public WebElement getContactLink() {
		return ContactLink;
	}


	public WebElement getLeadsLink() {
		return LeadsLink;
	}


	public WebElement getPurchaseOrderLink() {
		return PurchaseOrderLink;
	}


	public WebElement getProductLink() {
		return ProductLink;
	}


	public WebElement getAdminImage() {
		return AdminImage;
	}


	public WebElement getLogout() {
		return logout;
	}
	 public void loggingOut(WebDriver driver) {
		AdminImage.click();
		logout.click();
	 }
	
}
