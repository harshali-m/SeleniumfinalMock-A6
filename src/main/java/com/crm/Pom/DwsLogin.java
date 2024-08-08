package com.crm.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DwsLogin {
	public DwsLogin(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	private @FindBy(className="ico-login")
	WebElement Login_link;
	
	private @FindBy (id="Email")
	WebElement username;
	
	private @FindBy (name="Password")
	WebElement password;
	
	private @FindBy (xpath = "//input[@value='Log in']")
	WebElement login_button;
	
	public void login_link()
	{
		Login_link.click();
	}
	public void username(String user)
	{
		username.sendKeys(user);
	}
	public void password(String data2)
	{
		password.sendKeys(data2);
	}
	public void login_button()
	{
		login_button.click();
	}


}
