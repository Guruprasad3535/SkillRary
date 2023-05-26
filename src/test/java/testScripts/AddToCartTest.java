package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class AddToCartTest extends BaseClass {
	
	@Test
	public void addToCartTest() {
		SoftAssert soft=new SoftAssert();
		
		home.chooseLanguage();
		home.clickGearsTab();
		home.clickSkillraryDemo();
		web.handleChildBrowser();
		
		soft.assertTrue(demoApp.getLogoText().contains("ECommerce"));
		demoApp.mouseHoverToCourse(web);
		demoApp.clickSeleniumTraining();
		
		soft.assertEquals(selenium.getPageHeader(), "Selenium Training");
		
		int initialQuantity = Integer.parseInt(selenium.getQuantity());
		selenium.doubleClickPlusButton(web);
		int finalQuantity=Integer.parseInt(selenium.getQuantity());
		soft.assertEquals(finalQuantity, initialQuantity+1);
		
		selenium.clickAddToCart();
		web.handleAlert("ok");
		soft.assertEquals(selenium.getMessage(), "Item added to cart");
		
		
		soft.assertAll();
	}

}
