package testClasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pomPages.DashboardPage;
import pomPages.LoginPage;
import utilities.FetchData;

public class TestCases extends BaseClass {

	LoginPage login;
	DashboardPage dash;
	@BeforeMethod
	public void beforemethod() {
		login = new LoginPage(driver);
		dash = new DashboardPage(driver);

	}

	// Verify Successful Login With Valid Credentials
	@Test(priority = 3)
	public void verify_Valid_Credentials() throws EncryptedDocumentException, IOException {
		logger = report.createTest("Verify Valid Credentials");
		login.enterCredentials(FetchData.DataProvider(1, 0), FetchData.DataProvider(1, 1));
		login.clickLoginButton();
		String ExpectedURL = login.getloggedinURL();
		String ActualURL = login.CurrentURL();
		Assert.assertEquals(ExpectedURL, ActualURL);
	}

	// Verify Login With Invalid Credentials
	@Test(priority = 2)
	public void verify_Invalid_Credentials() throws EncryptedDocumentException, IOException {
		logger = report.createTest("Verify Invalid Credentials");
		login.clearbox();
		login.enterCredentials(FetchData.DataProvider(2, 0), FetchData.DataProvider(2, 1));
		login.clickLoginButton();
		String ExpectedURL = login.getloggedinURL();
		String ActualURL = login.CurrentURL();
		Assert.assertNotEquals(ExpectedURL, ActualURL);
	}

	// Verify Login With Empty Credentials
	@Test(priority = 2)
	public void verify_Empty_Credentials() throws EncryptedDocumentException, IOException {
		logger = report.createTest("Verify Empty Credentials");
		login = new LoginPage(driver);
		login.clearbox();
		login.enterCredentials("", "");
		login.clickLoginButton();
		String ExpectedURL = login.getloggedinURL();
		String ActualURL = login.CurrentURL();
		Assert.assertNotEquals(ExpectedURL, ActualURL);
	}

	// Verify Login Fails And Check Error Message Should Displayed OR Not
	@Test(priority = 1)
	public void verify_Login_Fails_Error_Message() throws IOException {
		logger = report.createTest("Verify Login Fails Error Message");
		login.clearbox();
		login.enterCredentials(FetchData.DataProvider(3, 0), FetchData.DataProvider(3, 1));
		login.clickLoginButton();
		String ActualMessage = login.ErrorMessage();
		String ExpectedMessage = "Invalid credentia";
		Assert.assertEquals(ExpectedMessage, ActualMessage);
	}

	// Verify Logo Is Visible Or Not
	@Test(priority = 0)
	public void verify_Logo() throws IOException {
		logger = report.createTest("Verify Logo");
		boolean LogoVisible = login.verifylogoimage();
		Assert.assertTrue(LogoVisible);
	}

	// Verify Page Title
	@Test(priority = -1)
	public void verify_Title() throws EncryptedDocumentException, IOException {
		logger = report.createTest("Verify Title");
		String ExpectedTitle = FetchData.DataProvider(4, 0);
		String ActualTitle = login.verifyTitle();
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}

	// Verify Search Functionality
	@Test(priority = 4, dependsOnMethods = { "verify_Valid_Credentials" })
	public void verify_Search_With_All_Tabs() throws EncryptedDocumentException, IOException {
		logger = report.createTest("Verify Search With All Tabs");

		SoftAssert s = new SoftAssert();
		dash.searchSend(FetchData.DataProvider(5, 0));
		boolean admin_Tab_Result = dash.adminCheck();
		Assert.assertTrue(admin_Tab_Result);
		dash.clearSearchBox();
		dash.searchSend(FetchData.DataProvider(6, 0));
		boolean pim_Tab_Result = dash.pimCheck();
		Assert.assertTrue(pim_Tab_Result);
		dash.clearSearchBox();
		dash.searchSend(FetchData.DataProvider(7, 0));
		boolean leave_Tab_Result = dash.leaveCheck();
		Assert.assertTrue(leave_Tab_Result);
		dash.clearSearchBox();
		dash.searchSend(FetchData.DataProvider(8, 0));
		boolean time_Tab_Result = dash.timeCheck();
		Assert.assertTrue(time_Tab_Result);
		dash.clearSearchBox();
		dash.searchSend(FetchData.DataProvider(9, 0));
		boolean recruitment_Tab_Result = dash.recruitmentCheck();
		Assert.assertTrue(recruitment_Tab_Result);
		dash.clearSearchBox();
		dash.searchSend(FetchData.DataProvider(10, 0));
		boolean myinfo_Tab_Result = dash.myinfoCheck();
		Assert.assertTrue(myinfo_Tab_Result);
		dash.clearSearchBox();
		dash.searchSend(FetchData.DataProvider(11, 0));
		boolean performance_Tab_Result = dash.performanceCheck();
		Assert.assertTrue(performance_Tab_Result);
		dash.clearSearchBox();
		dash.searchSend(FetchData.DataProvider(12, 0));
		Assert.assertTrue(dash.dashboardCheck());
		dash.clearSearchBox();
		dash.searchSend(FetchData.DataProvider(13, 0));
		Assert.assertTrue(dash.directoryCheck());
		dash.clearSearchBox();
		dash.searchSend(FetchData.DataProvider(14, 0));
		Assert.assertTrue(dash.maintenanceCheck());
		dash.clearSearchBox();
		dash.searchSend(FetchData.DataProvider(15, 0));
		Assert.assertTrue(dash.buzzCheck());
		dash.clearSearchBox();
		s.assertAll();

	}

	@Test(priority = 4)
	public void verify_Tabs_Colspan() {
		boolean CheckClickable = dash.panicButton();
		Assert.assertTrue(CheckClickable);
	}

	// Verify All Links in DashBoard Page Clickable
	@Test(priority = 5, dependsOnMethods = { "verify_Valid_Credentials" })
	public void verify_All_links_DashBoard() {
		logger = report.createTest("Verify All Links DashBoard");
		SoftAssert s = new SoftAssert();
		Assert.assertEquals(dash.dashStopWatchCheck(), dash.current_URL());
		dash.backNavigate();
//		s.assertEquals(dash.leaveRequestsToApproveCheck(), dash.current_URL());
//		dash.backNavigate();
//		s.assertEquals(dash.timesheetsToApproveCheck(), dash.current_URL());
//		dash.backNavigate();
//		s.assertEquals(dash.pendingSelfReviewCheck(), dash.current_URL());
//		dash.backNavigate();
//		s.assertEquals(dash.candidateToInterview(), dash.current_URL());
//		dash.backNavigate();
		String AtualURl = dash.assignLeave();
		String expectedURl = dash.current_URL();
		Assert.assertEquals(AtualURl, expectedURl);
		dash.backNavigate();
		Assert.assertEquals(dash.leaveList(), dash.current_URL());
		dash.backNavigate();
		Assert.assertEquals(dash.timeSheets(), dash.current_URL());
		dash.backNavigate();
		Assert.assertEquals(dash.applyLeave(), dash.current_URL());
		dash.backNavigate();
		Assert.assertEquals(dash.myLeave(), dash.current_URL());
		dash.backNavigate();
		Assert.assertEquals(dash.myTimeSheet(), dash.current_URL());
		dash.backNavigate();
		s.assertAll();
	}

	// Verify Profile About PopUP Located in Profile
	@Test(priority = 6, dependsOnMethods = { "verify_Valid_Credentials" })
	public void verify_Dash_Profile_About_PopupURL() {
		logger = report.createTest("Verify Dash Profile About PopupURL");
		SoftAssert s = new SoftAssert();
		dash.Clicked_Steps_Dash_Profile_About();
		boolean About_POPUP_Result = dash.popup_Displayed_Dash_Profile_About_Verify();
		Assert.assertTrue(About_POPUP_Result);
		dash.popup_Close_Dash_About();
		s.assertAll();
	}

	// Verify Profile Support Page Located in Profile
	@Test(priority = 7)
	public void verify_Dash_Profile_SupportPageURL() {
		logger = report.createTest("Verify Dash Profile SupportPageURL");
		SoftAssert s = new SoftAssert();
		String ExpectedURL = dash.dash_Profile_SupportPage();
		String ActualURL = dash.current_URL();
		Assert.assertEquals(ExpectedURL, ActualURL);
		dash.backNavigate();
		s.assertAll();

	}

	// Verify Profile Change Password Page Located in Profile
	@Test(priority = 8)
	public void verify_Dash_Profile_ChangePasswordURL() {
		logger = report.createTest("Verify Dash Profile ChangePasswordURL");
		SoftAssert s = new SoftAssert();
		String ExpectedURL = dash.dash_Profile_ChangePassword();
		String ActualURL = dash.current_URL();
		Assert.assertEquals(ExpectedURL, ActualURL);
		dash.backNavigate();
		s.assertAll();
	}

	// Verify Profile Logout Functionality Located in Profile
	@Test(priority = 9)
	public void verify_DashBoard_Logout_Functionality() {
		logger = report.createTest("Verify DashBoard Logout Functionality");
		String ExpectedURL = dash.dash_Profile_Logout_Functionality();
		String ActualURL = dash.current_URL();
		Assert.assertEquals(ExpectedURL, ActualURL);
	}
}
