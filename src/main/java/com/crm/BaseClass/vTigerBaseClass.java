package com.crm.BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.crm.FileUtility.PropertyUtility1;
import com.crm.Pom.vTigerLogin;

public class vTigerBaseClass {
public WebDriver driver;
	PropertyUtility1 eutil=new PropertyUtility1();
	
	@BeforeClass
	public void preCondition() throws IOException
	{
		String browser = PropertyUtility1.InputData("Browser");
		String url =PropertyUtility1.InputData("Url");

		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}
	 
	@BeforeMethod
	public void login() throws IOException
	{
		vTigerLogin l=new vTigerLogin(driver);
		l.userName().sendKeys(PropertyUtility1.InputData("Username"));
		l.password().sendKeys(PropertyUtility1.InputData("Password"));
		l.login();
	}
	
	@AfterMethod
	public void logout()
	{
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//td[@class='small'])[2]/img"))).perform();
		driver.findElement(By.partialLinkText("Sign Out")).click();
	}
	
	@AfterClass
	public void postCondition()
	{
		driver.quit();
	}

}
