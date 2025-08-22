package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampgainPage {

	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement createCampBtn;
	
	@FindBy(xpath = "//select[@class=\"form-control\"]")
	private WebElement searchDropDown;
	
	
	@FindBy(xpath = "//input[@placeholder=\"Search by Campaign Id\"]")
	private WebElement searchTextFeild;

	public CampgainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	public WebElement getCreateCampBtn() {
		return createCampBtn;
	}


	public WebElement getSearchDropDown() {
		return searchDropDown;
	}


	public WebElement getSearchTextFeild() {
		return searchTextFeild;
	}


}
