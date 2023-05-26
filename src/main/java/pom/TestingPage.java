package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * This class contains elements and respectiver 
 */
public class TestingPage {

	//Declaration
	@FindBy(xpath="//h1[@class='page-header']")
	private WebElement pageHeader;
	
	@FindBy(id="Python")
	private WebElement pythonImage;
	
	@FindBy(id="cartArea")
	private WebElement myCart;
	
	@FindBy(xpath="//ul/descendant::i[@class='fa fa-facebook']")
	private WebElement facebookIcon;
	
    //Initialization
	
	public TestingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	/*
	 * This method is used to get header text
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	/*
	 * This method is used to get Python Image
	 */
	public WebElement getPythonImage() {
		return pythonImage;
	}
	
	/*
	 * This method is used to get my cart area
	 * @return
	 */
	public WebElement getMyCart() {
		return myCart;
	}
	
	/*
	 * this method is used to get Mycart area
	 * @return
	 */
     public WebElement getFacebookIcon() {
    	 return facebookIcon;
     }
     
     /*
      * This method is used to click on facebook icon
      */
     public void clickFacebook() {
    	 facebookIcon.click();
     }
}
