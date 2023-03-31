package utilities;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenShot {
	public static void takescreenshot(WebDriver driver,String filename) throws IOException {
		Date getDate=new Date();
		String dateString=getDate.toString().replace(":"," ");
		File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File saveScreenShotFile=new File("src"+File.separator+"test"+File.separator+"resources"+File.separator+"screenshots"+File.separator+dateString+filename+".png");
		FileHandler.copy(srcFile, saveScreenShotFile);
	}
}
