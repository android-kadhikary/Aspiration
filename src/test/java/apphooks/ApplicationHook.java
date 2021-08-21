package apphooks;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHook {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order=0)
	public void getProperty() {
		
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		
	}
	
	@Before(order=1)
	public void launchBrowser() {
		
		String browserName = prop.getProperty("browser");
		//System.out.println("browserName = "+browserName);
		driverFactory = new DriverFactory();
		driver = driverFactory.initialize_driver(browserName);
		
	}
	
	@After(order =0)
	public void quitBrowser() {
		driver.quit();
	}
	@After(order =1)
	public void tearDown(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll("", "_");
		byte[] screenShotSourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
		 // Attach a screenshot. See your UI automation tool's docs for
		 // details about how to take a screenshot.
		// scenario.attach(pngBytes, "image/png", "Bartholomew and the Bytes of the Oobleck");
		 
		 
		scenario.attach(screenShotSourcePath, "image/png", screenshotName);
		
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
//if(osName.startWith("Mac")) {
//	FileUtils.copyFile(srcFile, new File(currentDir+"/screenshotd/"+System.currentTimeMillis()+".png"));
//}
//else {
	FileUtils.copyFile(srcFile, new File(currentDir+"\\New_screenshotd\\"+System.currentTimeMillis()+".png"));
	
	
		}
	}

	
}
