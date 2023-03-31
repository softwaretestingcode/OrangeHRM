package utilities;

import org.openqa.selenium.WebDriver;

public class CrossBrowser {
	static WebDriver driver;
	public static WebDriver CrossBrowserTesting(String browser) {
		if (browser.equals("chrome")) {
			driver = OpenBrowser.getChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = OpenBrowser.getFirefoxDriver();
		}
		return driver;
	}
}
