package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	
	@FindBy(xpath = "//select[@class=\"form-control\"]")
	private WebElement productDropDown;
	
	@FindBy(xpath = "//input[@placeholder=\"Search by product Id\"]")
	private WebElement productSearch;
	
	@FindBy(xpath = "//button[@class=\"btn btn-info\"]")
	private WebElement productBtn;

	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getProductDropDown() {
		return productDropDown;
	}


	public WebElement getProductSearch() {
		return productSearch;
	}


	public WebElement getProductBtn() {
		return productBtn;
	}

	
	
}
