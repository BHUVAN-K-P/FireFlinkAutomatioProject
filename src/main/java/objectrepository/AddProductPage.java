package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fireflink.ninzacrm.automationframework.genericUtiltiy.WebDriverUtility;

public class AddProductPage extends WebDriverUtility {

	@FindBy(xpath = "//input[@name=\"quantity\"]")
	private WebElement quantityTF;
	
	@FindBy(xpath = "//input[@name=\"productName\"]")
	private WebElement productNameTF;
	@FindBy(xpath = "//input[@name=\"price\"]")
	private WebElement priceTF;
	
	@FindBy(xpath = "//select[@name=\"productCategory\"]")
	private WebElement prodCatDropDown;
	
	@FindBy(xpath = "//select[@name=\\\"vendorId\\\"]")
	private WebElement vendorDropDown;
	
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addBtn;
	
	public AddProductPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public WebElement getQuantityTF() {
		return quantityTF;
	}


	public WebElement getProductNameTF() {
		return productNameTF;
	}


	public WebElement getPriceTF() {
		return priceTF;
	}


	public WebElement getProdCatDropDown() {
		return prodCatDropDown;
	}


	public WebElement getVendorDropDown() {
		return vendorDropDown;
	}
	
	
	public WebElement getAddBtn() {
		return addBtn;
	}


	public void addPorduct(WebDriver driver,String quantity,String name,String price,String cat,String vendor) {
		ProductPage pp=new ProductPage(driver);
		pp.getProductBtn().click();
		quantityTF.sendKeys(quantity);
		productNameTF.sendKeys(name);
		priceTF.sendKeys(price);
	dropDownHandle(prodCatDropDown, cat);
	dropDownHandle(vendor, vendorDropDown);
	addBtn.click();
	}
	
	
}
