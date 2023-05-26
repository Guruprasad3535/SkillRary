package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * This class contains elements and respective 
 */
public class ContactUsPage {

	//Declaration
	@FindBy(xpath="//img[contains(@src,'contactus')]")
	private WebElement pageLogo;
	
	@FindBy(name="name")
	private WebElement fullNameTF;
	
	@FindBy(name="sender")
	private WebElement emailTF;
	
	@FindBy(name="subject")
	private WebElement subjectTF;
	
	@FindBy(name="message")
	private WebElement messageTextArea;
	
	@FindBy(xpath="//button[text()='Send us mail']")
	private WebElement sendUsMailButton;
	
	//Initialization
	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	
	/*
	 * This method returns contact us page logo
	 * @return
	 */
	public WebElement getPageLogo() {
		return pageLogo;
	}
	
	/*
	 * This method is used to send contact details
	 * @param fullname
	 * @param email
	 * @param subject
	 * @param message
	 */
	public void sendDetails(String fullname,String email,String subject,String message) {
		fullNameTF.sendKeys(fullname);
		emailTF.sendKeys(email);
		subjectTF.sendKeys(subject);
		messageTextArea.sendKeys(message);
		sendUsMailButton.click();
	}
}
