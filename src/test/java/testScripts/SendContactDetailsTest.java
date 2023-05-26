package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class SendContactDetailsTest extends BaseClass{
	
	@Test
	public void sendContactDetailsTest() {
		
		SoftAssert soft=new SoftAssert();
		
		home.chooseLanguage();
		home.clickGearsTab();
		home.clickSkillraryDemo();
		web.handleChildBrowser();
		
		soft.assertTrue(demoApp.getLogoText().contains("ECommerce"));
		
		web.scrollToElement(demoApp.getContactUs());
		demoApp.clickContactUs();
		
		soft.assertTrue(contact.getPageLogo().isDisplayed());
		
		home.chooseLanguage();
		Map<String,String> map=excel.readDataFromExcel("sheet1");
		System.out.println(map);
		contact.sendDetails(map.get("Fullname"), map.get("Email"), map.get("Subject"), map.get("Message"));
		
		soft.assertAll();
		
		
	}

}
