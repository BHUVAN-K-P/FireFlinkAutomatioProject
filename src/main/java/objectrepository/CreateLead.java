package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLead {

	
	@FindBy(xpath = " //input[@name=\"leadStatus\"]")
	private WebElement leadStatusTF;
	
	
	@FindBy(xpath = " //input[@name=\"name\"]")
	private WebElement leadNameTF;
	
	@FindBy(xpath = " //input[@name=\"company\"]")
	private WebElement leadCompanyTF;
	
	@FindBy(xpath = " //input[@name=\"leadSource\"]")
	private WebElement leadSourceTF;
	
	@FindBy(xpath = " //input[@name=\"industry\"]")
	private WebElement leadIndustryTF;
	
	@FindBy(xpath = " //input[@name=\"phone\"]")
	private WebElement leadPhoneTF;
	
	
	@FindBy(xpath = " //input[@style=\"flex: 1 1 0%; margin-right: 10px;\"]")
	private WebElement CampgainDD;

	@FindBy(xpath = " //button[text()='Create Lead']")
	private WebElement createBtn;
	
	public CreateLead(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadStatusTF() {
		return leadStatusTF;
	}


	public WebElement getLeadNameTF() {
		return leadNameTF;
	}


	public WebElement getLeadCompanyTF() {
		return leadCompanyTF;
	}


	public WebElement getLeadSourceTF() {
		return leadSourceTF;
	}


	public WebElement getLeadIndustryTF() {
		return leadIndustryTF;
	}


	public WebElement getLeadPhoneTF() {
		return leadPhoneTF;
	}


	public WebElement getCampgainDD() {
		return CampgainDD;
	}


	public WebElement getCreateBtn() {
		return createBtn;
	}

	
	
}
