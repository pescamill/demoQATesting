package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.DemoQAMainPage;
import steps.DemoQASteps;
import steps.SwagLabsSteps;

public class SeleniumDemo {
	
	public WebDriver driver;
	SwagLabsSteps swagSteps;
	DemoQASteps demoQASteps;
	
	public final String demoBaseUrl = "https://demoqa.com/";
	public final String baseUrl = "https://www.saucedemo.com/";
	public final String driverPath = "src/main/resources/chromedriver";
	public final String standardUser = "standard_user";
	public final String password = "secret_sauce";
	
	@BeforeMethod
	private void startDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(demoBaseUrl);
		swagSteps = new SwagLabsSteps(driver);
		demoQASteps = new DemoQASteps(driver);
	}
	
	@Test
	public void sampleTestMethod() throws InterruptedException {
		demoQASteps.assertDynamicClick();
	}
	
	@Test
	public void sampleTestMethod2 () {
		demoQASteps.assertDoubleClick();
	}
	
	@Test
	public void sampleTestMethod3() {
		demoQASteps.assertRightClick();
	}
	
	@Test
	public void sampleTestMethod4() {
		driver.get(baseUrl);
		swagSteps.setUsername("standard_user");
		swagSteps.setPassword("secret_sauce");
	}
	
	@AfterMethod
	public void terminateBrowser() {
		driver.close();
	}
}
