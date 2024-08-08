package FinalMockTestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.BaseClass.DwsBaseClass;
import com.crm.FileUtility.ExcelUtility1;
import com.crm.Pom.Twitter;
public class Task4 extends DwsBaseClass {
	ExcelUtility1 eUtil = new ExcelUtility1();
	@Test
	public void twitterRegister() throws EncryptedDocumentException, IOException
	{
	Twitter t=new Twitter(driver);
	 assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
	List<WebElement> links= driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));
	List<WebElement> links1= links;
	for(WebElement w:links1)
	{
		if (w.getText().equalsIgnoreCase("twitter")) {
			w.click();
		}
	}
	
	int row1 = 0, row2 = 0;
	String dwsID = null;
	 Set<String> ids = driver.getWindowHandles();
	 for (String s : ids) {
		driver.switchTo().window(s);
		
		if("https://demowebshop.tricentis.com/".equalsIgnoreCase(driver.getCurrentUrl())) {
			dwsID = s;
		}
		
		 if ("https://x.com/nopCommerce".equalsIgnoreCase(driver.getCurrentUrl())) {
			
			System.out.println("Control Swicthed in twitter");
			Twitter t1 = new Twitter(driver);
			t1.createAccount();
			t1.name(eUtil.getData("Sheet1", row2++, 1));
			t1.phoneNumber(eUtil.getData("Sheet1", row2++, 1));
			t1.month(eUtil.getData("Sheet1", row2++, 1));
			t1.day(String.valueOf((int)Double.parseDouble(eUtil.getData("Sheet1", row2++, 1))));
			t1.year(String.valueOf((int)Double.parseDouble(eUtil.getData("Sheet1", row2++, 1))));
		} 
	}
	 
	 driver.switchTo().window(dwsID);
}
}
