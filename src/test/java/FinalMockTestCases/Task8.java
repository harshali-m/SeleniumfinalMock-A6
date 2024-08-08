package FinalMockTestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.BaseClass.vTigerBaseClass;
import com.crm.FileUtility.ExcelUtility1;
import com.crm.Pom.vTigerContacts;
import com.crm.Pom.vTigerHomePage;
import com.crm.javaUtility.vTigerJavaUtil;

public class Task8 extends vTigerBaseClass {
	ExcelUtility1 eUtil=new ExcelUtility1();
	@Test
	public void createContact() throws EncryptedDocumentException, IOException
	{
		vTigerHomePage home=new vTigerHomePage(driver);
		home.contacts();
		vTigerContacts con=new vTigerContacts(driver);
		con.plus();
		int row=0;
		String conName= eUtil.getData("Sheet3", row++, 0);
		con.lastName(conName+vTigerJavaUtil.generateRandomNumber(1000));
		con.getLastName();
		con.endDate(vTigerJavaUtil.endDate());
		con.saveBtn();
		assertTrue((con.getContactInfo().getText()).contains(conName));
	}

}
