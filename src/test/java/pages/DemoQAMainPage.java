package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DemoQAMainPage {
	
	public WebDriver driver;
	JavascriptExecutor executor;
	Actions action;
	WebDriverWait wait;
	
	public DemoQAMainPage(WebDriver driver){
		this.wait = new WebDriverWait(driver, 10);
		this.driver = driver;
		this.action = new Actions(driver);
		this.executor = (JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//h5[text()='Elements']/../../../div")
	public WebElement elementsSection;
	
	@FindBy (xpath = "//span[text()='Buttons']/..")
	public WebElement buttonSection;
	
	@FindBy (xpath = "//div[@class='mt-4'][2]//button")
	public WebElement singleClickButton;
	
	@FindBy (id = "doubleClickBtn")
	public WebElement doubleClickBtn;
	
	@FindBy (id = "rightClickBtn")
	public WebElement rightClickBtn;
	
	@FindBy (css = "#dynamicClickMessage")
	public WebElement dynamicMessage;
	
	@FindBy (css = "#doubleClickMessage")
	public WebElement doubleClickMessage;
	
	@FindBy (css = "#rightClickMessage")
	public WebElement rightClickMessage;
	
	public void clickLinkSection() {
		action.moveToElement(elementsSection).click().perform();
	}
	
	public void clickButtonSection() {
		action.moveToElement(buttonSection).perform();
		executor.executeScript("arguments[0].click();", buttonSection);
	}
	
	public void clickSingleClickBtn() {
		wait.until(ExpectedConditions.visibilityOf(singleClickButton));
		singleClickButton.click();
	}
	
	public void clickDoubleClickBtn() {
		wait.until(ExpectedConditions.visibilityOf(doubleClickBtn));
		action.doubleClick(doubleClickBtn).perform();
	}
	
	public void clickRightClickBtn() {
		wait.until(ExpectedConditions.visibilityOf(rightClickBtn));
		action.contextClick(rightClickBtn).perform();
	}
	
	public void assertDynamic() {
		Assert.assertEquals(dynamicMessage.getText(), "You have done a dynamic click");
	}
	
	public void assertDoubleClick() {
		Assert.assertEquals(doubleClickMessage.getText(), "You have done a double click");
	}
	
	public void assertRightClick() {
		Assert.assertEquals(rightClickMessage.getText(), "You have done a right click");
	}
	
}
