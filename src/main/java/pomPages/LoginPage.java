package pomPages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CaptureScreenShot;
import utilities.TimeOut;

public class LoginPage {
	WebDriver driver;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameField;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@class='orangehrm-login-branding']//img")
	private WebElement logoImage;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	private WebElement ErrorMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Enter Credentials and with Parameters
	public void enterCredentials(String username, String password) {
		TimeOut.waitForElementLocated(driver, usernameField).sendKeys(username);
		TimeOut.waitForElementLocated(driver, passwordField).sendKeys(password);
		
	}

	// Clear TextBox After One Positive of Negative Test Case
	public void clearbox() {
		TimeOut.waitForElementLocated(driver, usernameField).clear();
		TimeOut.waitForElementLocated(driver, passwordField).clear();
		
	}

	// Click On Login Button
	public void clickLoginButton() {
		TimeOut.waitForElementLocated(driver, loginButton).click();
	}

	// Go To Back
	public void back() {
		driver.navigate().back();
	}

	// Check Error Message Properly Displayed or not
	public String ErrorMessage() throws IOException {
		String errorString = TimeOut.waitForElementLocated(driver, ErrorMessage).getText();//Invalid credentials 
		ErrorMessage.getText();
		CaptureScreenShot.takescreenshot(driver, "Invalid Login");
		return errorString;
	}

	// Check Logo Image is Displayed
	public boolean verifylogoimage() throws IOException {
		boolean isLogoDisplayed = TimeOut.waitForElementLocated(driver, logoImage).isDisplayed();
		CaptureScreenShot.takescreenshot(driver, "Logo Visible");
		return isLogoDisplayed;
	}

	// Expected String URL
	public String getloggedinURL() {
		String expectedresultString = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		return expectedresultString;

	}

	// Get Current URL
	public String CurrentURL() {
		String urlString = driver.getCurrentUrl();
		return urlString;
	}

	// Verify Title
	public String verifyTitle() {
		String titleString = driver.getTitle();
		return titleString;
	}
}
