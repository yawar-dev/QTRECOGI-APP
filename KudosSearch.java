package QTRECOGNITION_YAW.Automating_QTRECOG;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;

public class KudosSearch extends base{
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
		lp.getUsername().sendKeys("prasad.bembde@qualitestgroup.com");
		lp.getPassword().sendKeys("P@ssw0rd");
		lp.clickLogin().click();
		
		ActivityPage aP = new ActivityPage(driver);
		aP.clickKudosSearch().click();
		
		KudosSearchPage ksp = new KudosSearchPage(driver);
		ksp.getEmail().sendKeys("anupam k");
		driver.findElement(By.xpath("//input[@id='s_e_add']")).sendKeys(Keys.ARROW_DOWN,Keys.RETURN);
		driver.findElement(By.xpath("//input[@id='s_e_add']")).sendKeys(Keys.ENTER,Keys.RETURN);
		
		ksp.ClickSearch().click();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();	
	}
}