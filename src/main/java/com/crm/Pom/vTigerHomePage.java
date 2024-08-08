package com.crm.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vTigerHomePage {
	public vTigerHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	private @FindBy(linkText = "Organizations")
	WebElement org;
	public WebElement getOrganizations()
	{
		return org;
	}
	public void organizations()
	{
		org.click();
	}
	
	private @FindBy(linkText = "Contacts")
	WebElement contact;
	public WebElement getContacts()
	{
		return contact;
	}
	public void contacts()
	{
		contact.click();
	}
	private @FindBy(xpath="(//a[contains(text(),'Gift Cards')])[1]")
	WebElement GiftCard;
	
	public void giftCard()
	{
		GiftCard.click(); 
	}
	private @FindBy(xpath = "(//a[@class='ico-cart'])[1]")
	WebElement cart;
	public void cart()
	{
		cart.click();
	}

}
