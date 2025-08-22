package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {

	
	
	@FindBy(xpath = "//span[text()=\"Create Lead\"]/parent::button")
	private WebElement createLead;
	

	@FindBy(xpath = " //select[@class=\"form-control\"]")
	private WebElement searchDropDown;
	
	
	@FindBy(xpath = " //input[@placeholder=\"Search by Lead Id\"]")
	private WebElement searchText;
	
	LeadPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateLead() {
		return createLead;
	}


	public WebElement getSearchDropDown() {
		return searchDropDown;
	}


	public WebElement getSearchText() {
		return searchText;
	}

	
	
}
