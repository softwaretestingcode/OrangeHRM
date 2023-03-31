package pomPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TimeOut;

public class DashboardPage {
	Actions act;
	WebDriver driver;
	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement searchBox;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']//span[text()='Admin']")
	private WebElement adminTab;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']//span[text()='PIM']")
	private WebElement pimTab;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']//span[text()='Leave']")
	private WebElement leaveTab;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']//span[text()='Time']")
	private WebElement timeTab;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']//span[text()='Recruitment']")
	private WebElement recruitmentTab;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']//span[text()='My Info']")
	private WebElement myinfoTab;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']//span[text()='Performance']")
	private WebElement performanceTab;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']//span[text()='Dashboard']")
	private WebElement dashboardTab;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']//span[text()='Directory']")
	private WebElement directoryTab;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']//span[text()='Maintenance']")
	private WebElement maintenanceTab;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']//span[text()='Buzz']")
	private WebElement buzzTab;

	// Dashboard Page StopWatch button
	@FindBy(xpath = "//i[@class='oxd-icon bi-stopwatch']")
	private WebElement stopwatchIcon;

	@FindBy(xpath = "//p[contains(normalize-space(),'Leave Requests to Approve')]")
	private WebElement leaveRequestsToApprove;

	@FindBy(xpath = "//p[contains(normalize-space(),'Timesheets to Approve')]")
	private WebElement timesheetsToApprove;

	@FindBy(xpath = "//p[contains(normalize-space(),'Pending Self Review')]")
	private WebElement pendingSelfReview;

	@FindBy(xpath = "//p[contains(normalize-space(),'Candidate to Interview')]")
	private WebElement candidateToInterview;

	@FindBy(xpath = "//button[@title='Assign Leave']//*[name()='svg']")
	private WebElement assignLeaveButton;

	@FindBy(xpath = "//button[@title='Leave List']//*[name()='svg']")
	private WebElement leaveListButton;

	@FindBy(xpath = "//button[@title='Timesheets']//*[name()='svg']")
	private WebElement timesheetsButton;

	@FindBy(xpath = "//button[@title='Apply Leave']//*[name()='svg']")
	private WebElement applyLeaveButton;

	@FindBy(xpath = "//button[@title='My Leave']//*[name()='svg']")
	private WebElement myLeaveButton;

	@FindBy(xpath = "//button[@title='My Timesheet']//*[name()='svg']")
	private WebElement myTimesheetButton;

	// profile drop
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	private WebElement profileDropdown;

	@FindBy(xpath = "//a[normalize-space()='About']")
	private WebElement aboutLink;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-about-text'][normalize-space()='OrangeHRM OS 5.3']")
	private WebElement aboutText;

	@FindBy(xpath = "//button[@class='oxd-dialog-close-button oxd-dialog-close-button-position']")
	private WebElement aboutPopUpCloseButton;

	@FindBy(xpath = "//a[normalize-space()='Support']")
	private WebElement supportLink;

	@FindBy(xpath = "//a[normalize-space()='Change Password']")
	private WebElement changePasswordLink;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement logoutLink;

	@FindBy(xpath = "//i[@class='oxd-icon bi-chevron-left']")
	private WebElement arrowIcon;
	
	
	
	

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clearSearchBox() {
		for (int i = 0; i <= 15; i++) {
			TimeOut.waitForElementLocated(driver, searchBox).sendKeys(Keys.BACK_SPACE);
		}
	}

	public void searchSend(String name) {
		TimeOut.waitForElementLocated(driver, searchBox).sendKeys(name);

	}

	public boolean adminCheck() {

		TimeOut.waitForElementLocated(driver, adminTab);
		boolean admin = adminTab.isDisplayed();
		return admin;
	}

	public boolean pimCheck() {

		TimeOut.waitForElementLocated(driver, pimTab);
		boolean pim = pimTab.isDisplayed();
		return pim;
	}

	public boolean leaveCheck() {

		TimeOut.waitForElementLocated(driver, leaveTab);
		boolean leave = leaveTab.isDisplayed();
		return leave;
	}

	public boolean timeCheck() {

		TimeOut.waitForElementLocated(driver, timeTab);
		boolean time = timeTab.isDisplayed();
		return time;
	}

	public boolean recruitmentCheck() {
		TimeOut.waitForElementLocated(driver, recruitmentTab);
		boolean recruitment = recruitmentTab.isDisplayed();
		return recruitment;
	}

	public boolean myinfoCheck() {
		TimeOut.waitForElementLocated(driver, myinfoTab);
		boolean myinfo = myinfoTab.isDisplayed();
		return myinfo;
	}

	public boolean performanceCheck() {
		TimeOut.waitForElementLocated(driver, performanceTab);
		boolean performance = performanceTab.isDisplayed();
		return performance;
	}

	public boolean dashboardCheck() {
		TimeOut.waitForElementLocated(driver, dashboardTab);
		boolean dashboard = dashboardTab.isDisplayed();
		return dashboard;
	}

	public boolean directoryCheck() {
		TimeOut.waitForElementLocated(driver, directoryTab);
		boolean directory = directoryTab.isDisplayed();
		return directory;
	}

	public boolean maintenanceCheck() {
		TimeOut.waitForElementLocated(driver, maintenanceTab);
		boolean maintenance = maintenanceTab.isDisplayed();
		return maintenance;
	}

	public boolean buzzCheck() {
		TimeOut.waitForElementLocated(driver, buzzTab);
		boolean buzz = buzzTab.isDisplayed();
		return buzz;
	}

	public void backNavigate() {
		driver.navigate().back();
	}

	public String dashStopWatchCheck() {
		TimeOut.waitForElementLocated(driver, stopwatchIcon).click();
		String dashStopWatchURL = "https://opensource-demo.orangehrmlive.com/web/index.php/attendance/punchIn";
		return dashStopWatchURL;
	}

	public String leaveRequestsToApproveCheck() {
		TimeOut.waitForElementLocated(driver, leaveRequestsToApprove).click();
		String leaveRequestsToApproveURL = "https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList";
		return leaveRequestsToApproveURL;
	}

	public String timesheetsToApproveCheck() {
		TimeOut.waitForElementLocated(driver, timesheetsToApprove).click();
		String timesheetsToApproveURL = "https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet";
		return timesheetsToApproveURL;
	}

	public String pendingSelfReviewCheck() {
		TimeOut.waitForElementLocated(driver, pendingSelfReview).click();
		String pendingSelfReviewURL = "https://opensource-demo.orangehrmlive.com/web/index.php/performance/myPerformanceReview";
		return pendingSelfReviewURL;
	}

	public String candidateToInterview() {
		TimeOut.waitForElementLocated(driver, candidateToInterview).click();
		String candidateToInterviewURL = "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates?statusId=4";
		return candidateToInterviewURL;
	}

	public String assignLeave() {
		TimeOut.waitForElementLocated(driver, assignLeaveButton).click();
		String assignLeaveURL = "https://opensource-demo.orangehrmlive.com/web/index.php/leave/assignLeave";
		return assignLeaveURL;
	}

	public String leaveList() {
		TimeOut.waitForElementLocated(driver, leaveListButton).click();
		String leaveListURL = "https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList";
		return leaveListURL;
	}

	public String timeSheets() {
		TimeOut.waitForElementLocated(driver, timesheetsButton).click();
		String timeSheetsURL = "https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet";
		return timeSheetsURL;
	}

	public String applyLeave() {
		TimeOut.waitForElementLocated(driver, applyLeaveButton).click();
		String applyLeaveURL = "https://opensource-demo.orangehrmlive.com/web/index.php/leave/applyLeave";
		return applyLeaveURL;
	}

	public String myLeave() {
		TimeOut.waitForElementLocated(driver, myLeaveButton).click();
		String myLeaveURL = "https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewMyLeaveList";
		return myLeaveURL;
	}

	public String myTimeSheet() {
		TimeOut.waitForElementLocated(driver, myTimesheetButton).click();
		String myTimeSheetURL = "https://opensource-demo.orangehrmlive.com/web/index.php/time/viewMyTimesheet";
		return myTimeSheetURL;
	}

	public void Clicked_Steps_Dash_Profile_About() {
		TimeOut.waitForElementLocated(driver, profileDropdown).click();
		TimeOut.waitForElementLocated(driver, aboutLink).click();

	}

	public boolean popup_Displayed_Dash_Profile_About_Verify() {
		TimeOut.waitForElementLocated(driver, aboutText);
		boolean verifyDashProfileAboutVerifyit = aboutText.isDisplayed();
		return verifyDashProfileAboutVerifyit;
	}

	public void popup_Close_Dash_About() {
		TimeOut.waitForElementLocated(driver, aboutPopUpCloseButton).click();
	}

	public String dash_Profile_SupportPage() {
		TimeOut.waitForElementLocated(driver, profileDropdown).click();
		TimeOut.waitForElementLocated(driver, supportLink).click();
		String supportURL = "https://opensource-demo.orangehrmlive.com/web/index.php/help/support";
		return supportURL;
	}

	public String current_URL() {
		String urlString = driver.getCurrentUrl();
		return urlString;
	}

	public String dash_Profile_ChangePassword() {
		TimeOut.waitForElementLocated(driver, profileDropdown).click();
		TimeOut.waitForElementLocated(driver, changePasswordLink).click();
		String changePasswordURL = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/updatePassword";
		return changePasswordURL;
	}

	public String dash_Profile_Logout_Functionality() {
		TimeOut.waitForElementLocated(driver, profileDropdown).click();
		TimeOut.waitForElementLocated(driver, logoutLink).click();
		String logoutedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		return logoutedURL;
	}

	public boolean panicButton() {
		act = new Actions(driver);
		TimeOut.waitForElementLocated(driver, arrowIcon);
		boolean buttonCheck = arrowIcon.isEnabled();
		act.doubleClick(arrowIcon).perform();
		return buttonCheck;
	}

}
