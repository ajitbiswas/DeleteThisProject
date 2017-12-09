package generic;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant  {
	
	static{
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}

	public static WebDriver driver;
	@BeforeMethod
	public void openApplication(){

		driver = new FirefoxDriver();
		String url = Lib.getProperty(CONFIG_PATH, "URL");
		driver.get(url);
		String Stringtime = Lib.getProperty(CONFIG_PATH, "ITO");
		int time = Integer.parseInt(Stringtime);
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeApplication(){
		driver.close();
	}
	
	public void getScreenshotOnTestFailure(String testname){
		Date d = new Date();
		String currentdate = d.toString().replaceAll(":", "_");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".\\FailedTestScripts_Screenshots\\"+currentdate+"\\"+testname+"_screenshot.png");
		try {
			FileUtils.copyFile(srcFile, destFile);
			
		} catch (Exception e) {
		}
	}
}
