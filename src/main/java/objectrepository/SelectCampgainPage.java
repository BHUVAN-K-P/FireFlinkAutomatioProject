package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectCampgainPage {

	@FindBy(xpath="//select[@id=\"search-criteria\"]")
	private WebElement campIdDropDown;
	
	@FindBy(xpath="//select[@id=\"search-input\"]")
	private WebElement campIdSearch;
	
	@FindBy(xpath="//select[@onclick=\"selectCampaign('CAM00001', 'Campaigntest')\"]")
	private WebElement campIdDropDown;
}
