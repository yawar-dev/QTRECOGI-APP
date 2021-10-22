package QTRECOGNITION_YAW.Automating_QTRECOG;
//import java.awt.Color;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Login_verif{
	 public WebDriver driver;
	


	@Test
	public void userLogin() {
		driver.get("https://qtrecognition.testqtwiz.com/Activity.php");
		String goldenCOLR = driver.findElement(By.xpath("//div[@class='myHeading']")).getCssValue("background-color");
		String gol = Color.fromString( goldenCOLR).asHex(); 
		System.out.println(gol);

//		String col_NavyBlue = driver.findElement(By.cssSelector("button[@type='submit']")).getCssValue("background-color");
//		String nav_blue= Color.fromString(col_NavyBlue).asHex(); 
//		System.out.println( nav_blue);
//		
		
		LoginPage lv= new LoginPage(driver);
        
		//Login with valid user credentials
		lv.getUsername().sendKeys("yawar.bhat@qualitestgroup.com");
		lv.getPassword().sendKeys("P@ssw0rd");
		lv.clickLogin().click();
		String heading=driver.findElement(By.xpath("//div[@class='myHeading']//h1")).getText();
		System.out.println(heading);
		
		//Asserts
				Assert.assertEquals(heading,"QTRecognition"); //False
				System.out.println(driver.getTitle());
				
				//asserting whether it is golden color hex value or not
			    Assert.assertEquals(gol,"#FECC160");
			 
			    //asserting whether it is navy blue color hex value or not
			  // Assert.assertEquals(nav_blue,"#2A2559");
	
		
	}
	
//	@AfterTest
//	public void Terminate()
//	{
//		driver.close();	
//	}
}