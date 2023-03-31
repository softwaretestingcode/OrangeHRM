package pomPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath = "//a[.='Admin']")
	private WebElement adminTab;

	@FindBy(xpath = "//span[text()='User Management ']")
	private WebElement userManagementTab;

	@FindBy(xpath = "//span[text()='Job ']")
	private WebElement jobTab;

	@FindBy(xpath = "//span[text()='Organization ']")
	private WebElement organizationTab;

	@FindBy(xpath = "//span[text()='Qualifications ']")
	private WebElement qualificationsTab;

	@FindBy(xpath = "//a[text()='Nationalities']")
	private WebElement nationalitiesTab;

	@FindBy(xpath = "//a[text()='Corporate Branding']")
	private WebElement corporateBrandingTab;

	@FindBy(xpath = "//span[text()='Configuration ']")
	private WebElement configurationTab;

	@FindBy(xpath = "//div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active']")
	private WebElement systemUsername;
	
	//remaining
	@FindBy(xpath = "(//div[@class='oxd-select-text-input'][contains(.,'-- Select --')])[1]")
	private WebElement UserRole;

	@FindBy(xpath = "//div[@role='option']//span[contains(text(),'Admin')]")
	private WebElement UserRoleSelect;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement EmployeeName;

	@FindBy(xpath = "//span[contains(text(),'Rushikesh')]")
	private WebElement EmployeeNameSelect;

	@FindBy(xpath = "//div[@class='oxd-select-text-input xpather-highlight'][contains(.,'-- Select --')]")
	private WebElement Status;

	@FindBy(xpath = "//span[normalize-space()='Enabled']")
	private WebElement StatusEnabled;
	
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Search')]")
	private WebElement search;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void verifyAdminTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Admin']")));
		
		Boolean Compareadmin = "Admin".equals(adminTab.getText());
		System.out.println("Admin Element is Displayed = " + adminTab.isDisplayed());
		System.out.println("Admin Element is Enabled = " + adminTab.isEnabled());
		adminTab.click();
		System.out.println("Admin Lable Verify Spelling = " + Compareadmin);
	}

	public void verifyUserManagementTab() {
		System.out.println(System.lineSeparator());
		Boolean CompareUserManagementBoolean = "User Management".equals(userManagementTab.getText());
		System.out.println("User Management Verity Lable = " + CompareUserManagementBoolean);
	}

	public void verifyJobTab() {
		System.out.println(System.lineSeparator());
		Boolean compareJoBoolean = "Job".equals(jobTab.getText());
		System.out.println("Job Verify Text = " + compareJoBoolean);
	}

	public void verifyOrgaizationTab() {
		System.out.println(System.lineSeparator());
		Boolean comapreOrganizationBoolean = "Organization".equals(organizationTab.getText());
		System.out.println("Organization Verify Text = " + comapreOrganizationBoolean);
	}

	public void verifyQualificationsTab() {
		System.out.println(System.lineSeparator());
		Boolean compareQualificationsBoolean = "Qualifications".equals(qualificationsTab.getText());
		System.out.println("Qualifications Verify Text = " + compareQualificationsBoolean);
	}

	public void verifyNationalitiesTab() {
		System.out.println(System.lineSeparator());
		Boolean ComapreNationalities = "Nationalities".equals(nationalitiesTab.getText());
		System.out.println("Nationalities Verify Text = " + ComapreNationalities);
	}

	public void verifyCorporateBrandingTab() {
		System.out.println(System.lineSeparator());
		Boolean ComapreCorporateBranding = "Corporate Branding".equals(corporateBrandingTab.getText());
		System.out.println("Corporate Branding Verify Text = " + ComapreCorporateBranding);
	}

	public void verifyConfigurationTab() {
		System.out.println(System.lineSeparator());
		Boolean CompareConfiguration = "Configuration".equals(configurationTab.getText());
		System.out.println("Configuration Verify Text = " + CompareConfiguration);

	}

	public void verifySystemUsernameTextBox(String username) {
		System.out.println(System.lineSeparator());
		systemUsername.sendKeys(username, Keys.ENTER);
	}
	
	public void verifyUserRole() {
		UserRole.click();
		UserRoleSelect.click();
		search.click();
	}
}
