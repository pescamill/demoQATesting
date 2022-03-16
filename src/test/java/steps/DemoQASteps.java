package steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.DemoQAMainPage;


public class DemoQASteps {
	WebDriver driver;
	JavascriptExecutor executor;
	Actions action;

	DemoQAMainPage  qaMainPage;

	public DemoQASteps(WebDriver driver) {
		this.driver = driver;
		this.action = new Actions(driver);
		this.executor = (JavascriptExecutor)driver;
		this.qaMainPage = new DemoQAMainPage(driver);
	}
	
	public void assertDynamicClick() {
		qaMainPage.clickLinkSection();
		qaMainPage.clickButtonSection();
		qaMainPage.clickSingleClickBtn();
		qaMainPage.assertDynamic();
	}
	
	public void assertDoubleClick() {
		qaMainPage.clickLinkSection();
		qaMainPage.clickButtonSection();
		qaMainPage.clickDoubleClickBtn();
		qaMainPage.assertDoubleClick();
	}
	
	public void assertRightClick() {
		qaMainPage.clickLinkSection();
		qaMainPage.clickButtonSection();
		qaMainPage.clickRightClickBtn();
		qaMainPage.assertRightClick();
	}
	
}
