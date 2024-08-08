package com.crm.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Twitter {
	public Twitter(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy(xpath = "//span[text()='Create account']")
	WebElement cA;
	
	public void createAccount()
	{
		cA.click();
	}
	
	private @FindBy(name = "name")
	WebElement n;
	
	public void name(String name)
	{
		n.sendKeys(name);
	}
	
	private @FindBy(name = "phone_number")
	WebElement pN;
	
	public void phoneNumber(String phoneNumber)
	{
		pN.sendKeys(phoneNumber);
	}
	
	private @FindBy(xpath = "(//div[@aria-label=\"Date of birth\"])[2]/div[1]/select")
	WebElement mon;
	
	public void month(String visibleMonth)
	{
		Select s =  new Select(mon);
		s.selectByVisibleText(visibleMonth);
	}
	
	private @FindBy(xpath = "(//div[@aria-label=\"Date of birth\"])[2]/div[2]/select")
	WebElement d;
	
	public void day(String visibleDay)
	{
		Select s = new Select(d);
		s.selectByVisibleText(visibleDay);
	}
	
	private @FindBy(xpath = "(//div[@aria-label=\"Date of birth\"])[2]/div[3]/select")
	WebElement y;
	
	public void year(String visibleYear)
	{
		Select s = new Select(y);
		s.selectByVisibleText(visibleYear);
	}
}
