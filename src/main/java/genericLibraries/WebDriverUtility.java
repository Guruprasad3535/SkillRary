package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {

	private WebDriver driver;

//	Launching the Browsers and setting up
	
    /*
     * This method is used launch the specific browser
     * @param browser
     * @return
     */
	public WebDriver launchBrowser(String browser) {
		
		switch(browser) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
		default : System.out.println("invalid browser info");
		}
		return driver;
	}
	
	/*
	 * This method is used to maximize the window
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	
	/*
	 * This method is used to navigate to specified application 
	 * @param url
	 */
	public void navigateToApp(String url) {
		driver.get(url);
	}
	
//	Waiting statements
	
	/*
	 * This method is used to wait until element or list of elements is found
	 * @param time
	 */
	public void waitUntilElementFound(long time) {
        driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}
	
	/*
	 * This method is used to wait until element is visible
	 * @param time 
	 * @param element
	 * @return
	 */
	
	public WebElement explicitWait(long time, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/*
	 * This method is used to wait until title of webpage is found
	 * @param time
	 * @param title 
	 * @return
	 */
	public boolean explicitWait(long time,String title) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.titleContains(title));
	}
	
//	Mouse Actions
	
	/*
	 * This method is  used to mouse hover on an element
	 * @param element
	 */
	public void mouseOver(WebElement element) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	/*
	 * This method is  used to double click on an element
	 * @param element
	 */
	public void doubleClickOnElement(WebElement element) {
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	/*
	 * This method is  used to right click on an element
	 * @param element
	 */
	public void rightClick(WebElement element) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	/*
	 * This method is  used to drag and drop an element to dest
	 * @param element
	 * @param dest
	 */
	public void dragAndDropElement(WebElement element,WebElement dest) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
//	Frame control
	
	/*
	 * This method is used to switch to frame based on frame index
	 * @param index
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	
	/*
	 * This method is used to switch to frame based on id or name attribute
	 * @param idOrName
	 */
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	/*
	 * This method is used to switch to frame based on frame element
	 * @param frameElement
	 */
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	/*
	 * This method is used to switch back from frame
	 */
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}
	
//	Screenshot
	
	/*
	 * This method is used to take screenshot of Web page
	 */
	public void takeScreenshot() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/screenshot.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	JavaScriptExecutor
	
	/*
	 * This method is used to scroll till the element
	 * @param element
	 */
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
//	DropDowns libraries
	
	/*
	 * This method selects an element from drop down using value
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/*
	 * This method selects an element from drop down using value
	 * @param element
	 * @param value
	 */
	public void dropdown(WebElement element ,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	/*
	 * This method selects an element from drop down using value
	 * @param text
	 * @param element
	 */
	public void dropdown(String text,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
//	Pop up's libraries

	/*
	 * This method is used to handle the alert pop up
	 * @param status
	 */
	public void handleAlert(String status) {
		Alert alert=driver.switchTo().alert();
		if(status.equalsIgnoreCase("ok"))
		   alert.accept();
		else
			alert.dismiss();
	}
	
	/*
	 * This method is used to switch to parent window
	 */
	public void switchToParentWindow() {
		String parentID=driver.getWindowHandle();
		driver.switchTo().window(parentID);
	}
	
	/*
	 * This method is used to switch to child window
	 */
	public void handleChildBrowser() {
		Set<String> set=driver.getWindowHandles();
		for(String id:set) {
			driver.switchTo().window(id);
		}
	}
	
	/*
	 * This method is used to close the current tab
	 */
	public void closeCurrentTab() {
		driver.close();
	}
	
	/*
	 * This method is used to close all the tabs
	 */
	public void quitAllWindows() {
		driver.quit();
	}
}
