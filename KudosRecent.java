package QTRECOGNITION_YAW.Automating_QTRECOG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
public class KudosRecent extends base{
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
	}
	@Test
	public void sendKudos(){
		
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("yawar.bhat@qualitestgroup.com");
		lp.getPassword().sendKeys("P@ssw0rd");
		lp.clickLogin().click();
		
		ActivityPage AP=new ActivityPage(driver);
		AP.clickRecentKudos().click();
		
		SendKudosPage skp = new SendKudosPage(driver);
		skp.getWriteAppreciationMsg().click();
		skp.getComment().sendKeys("Good Work");
		skp.getSendButton().click();
	}
	@AfterTest
	public void teardown()
	{
		driver.close();	
	}
}