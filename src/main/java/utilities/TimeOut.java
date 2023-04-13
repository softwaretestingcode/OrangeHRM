package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeOut {
	//Explicit Wait
	public static WebElement waitForElementLocated(WebDriver driver,WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10)); //500ms intervel
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
}
