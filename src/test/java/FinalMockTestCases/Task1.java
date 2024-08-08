package FinalMockTestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.BaseClass.DwsBaseClass;
import com.crm.FileUtility.ExcelUtility1;
import com.crm.Pom.Cart;
import com.crm.Pom.GiftCard;

public class Task1 extends DwsBaseClass {
	ExcelUtility1 eUtil = new ExcelUtility1();
	@Test
	public void giftCard() throws EncryptedDocumentException, IOException, InterruptedException
	{
		assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
		
		GiftCard gCard = new GiftCard(driver);
		gCard.giftCard();
		
		int row = 0;
		Thread.sleep(2000);
		gCard.giftCard25();
		gCard.rName(eUtil.getData("Sheet4", row++, 0));
		gCard.rEmail(eUtil.getData("Sheet4", row++, 0));
		gCard.getSName().clear();
		gCard.sName(eUtil.getData("Sheet4", row++, 0));
		gCard.getSEmail().clear();
		gCard.sEmail(eUtil.getData("Sheet4", row++, 0));	
		gCard.giftMsg(eUtil.getData("Sheet4", row++, 0));
		gCard.giftQty(String.valueOf((int)Double.parseDouble(eUtil.getData("Sheet4", row++, 0))));
		Thread.sleep(2000);
		gCard.addToCart();
		
		gCard.cart();
		Thread.sleep(2000);		
		Cart c = new Cart(driver);
		assertTrue(c.getverifyGiftCard().isDisplayed(), "$25 product is not displayed in cart");
	}

}
