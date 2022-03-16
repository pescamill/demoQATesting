package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsPage {
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='user-name']")
	public WebElement userNameInput;
	
	@FindBy (id = "password")
	public WebElement passwordInput;
	
	@FindBy (css = "login-button")
	public WebElement loginButton;
	
	public SwagLabsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Set UserName
	public void setUsername(String username) {
		userNameInput.sendKeys(username);
	}
	
	//Set Password
	public void setPassword(String password) {
		userNameInput.sendKeys(password);
	}
	
	//Click login
	public void clickLogin() {
		loginButton.click();
	}
	
	public void loginToSwags(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
		this.clickLogin();
	}
}
