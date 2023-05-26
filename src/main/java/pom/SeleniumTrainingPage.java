package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

/*
 * This class contains elements and respective business libraries of Selenium Training page
 * @author gpss
 */
public class SeleniumTrainingPage {
	
	//Declaration
	@FindBy(xpath="//h1[@class='page-header']")
	private WebElement pageHeader;
	
	@FindBy(id="add")
	private WebElement plusButton;
	
	@FindBy(id="quantity")
	private WebElement quantity;
	
	@FindBy(xpath="//button[.=' Add to Cart']")
	private WebElement addToCartButton;
	
	@FindBy(xpath="//div[@class='callout callout-success']/span")
	private WebElement message;
	
	//Initialization
	
	public SeleniumTrainingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	/*
	 * This method returns page header of selenium training page
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	/*
	 * This method is used to double click on plus button
	 * @param web
	 */
	public void doubleClickPlusButton(WebDriverUtility web) {
		
		web.doubleClickOnElement(plusButton);
	}
	
	/*
	 * This method is used to get the quantity of added items
	 * @return
	 */
	public String getQuantity() {
		return quantity.getAttribute("value");
	}
	
	/*
	 * This method is used to click on add to cart button
	 */
	public void clickAddToCart() {
		addToCartButton.click();
	}
	
	/*
	 * This method is used to get the text on the item added message 
	 * @return
	 */
	public String getMessage() {
		return message.getText();
	}
}
