package steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pages.SwagLabsPage;

public class SwagLabsSteps {

	WebDriver driver;
	JavascriptExecutor executor; 
	Actions action; 
	
	SwagLabsPage swagsPage;
	
	public SwagLabsSteps(WebDriver driver) {
		this.driver = driver;
		this.action = new Actions(driver);
		this.executor = (JavascriptExecutor)driver;
		this.swagsPage = new SwagLabsPage(driver);
	}
	
	private void jsClick(WebElement element) {
		executor.executeScript("arguments[0].click();", element);
	}
	
	private void normalClick(WebElement element) {
		element.click();
	}
	
	public void setUsername(String username) {
		swagsPage.userNameInput.sendKeys(username);
	}
	
	public void setPassword(String password) {
		swagsPage.passwordInput.sendKeys(password);
	}
	
	public void clickLogin() {
		swagsPage = new SwagLabsPage(driver);
		normalClick(swagsPage.loginButton);
	}
	
}
