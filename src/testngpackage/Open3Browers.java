package testngpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Open3Browers {
	static{
		System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver", ".\\driver\\IEDriverServer.exe");
	}
	WebDriver driver;
	
	@Test
	@Parameters({"browser"})
	public void launchbrowser(String browser){
		
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if(browser.equals("chrome")){
			driver = new ChromeDriver();
		} else{
			driver = new InternetExplorerDriver();
			
		}
		driver.get("http://www.google.com");
		driver.close();
	}
}
