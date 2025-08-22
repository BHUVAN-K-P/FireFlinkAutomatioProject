package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	@FindBy(xpath = "//select[@class=\"form-control\"]")
	private WebElement contactDropDown;
	
	@FindBy(xpath = "//input[@placeholder=\"Search by Contact Id\"]")
	private WebElement contactSearch;
	
	
	@FindBy(xpath = "//button[@class=\"btn btn-info\"]")
	private WebElement createContact;
	
	
	public  ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
		
	}


	 public WebElement getContactDropDown() {
		 return contactDropDown;
	 }




	 public WebElement getContactSearch() {
		 return contactSearch;
	 }




	 public WebElement getCreateContact() {
		 return createContact;
	 }


}
