package FinalMockTestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.BaseClass.vTigerBaseClass;
import com.crm.FileUtility.ExcelUtility1;
import com.crm.Pom.vTigerHomePage;
import com.crm.Pom.vTigerOrganization;
import com.crm.javaUtility.vTigerJavaUtil;

public class Task7 extends vTigerBaseClass {
	ExcelUtility1 eUtil = new ExcelUtility1();
	@Test
	public void createOrganization() throws EncryptedDocumentException, IOException
	{
		vTigerHomePage home = new vTigerHomePage(driver);
		home.organizations();
		
		int row = 0;
		vTigerOrganization org = new vTigerOrganization(driver);
		org.plusIcon();
		String orgName= eUtil.getData("Sheet2", row++, 0);
		org.organizationName(orgName+vTigerJavaUtil.generateRandomNumber(1000));
		org.group();
		org.assignedto(eUtil.getData("Sheet2", row++, 0));
		String industry = eUtil.getData("Sheet2", row++, 0);
		org.selectIndustry(industry);
		assertTrue((org.getIndustry().getText()).contains(industry));
		org.saveBtn();
		assertTrue((org.getCreatedOrgText().getText()).contains(orgName));
	}

}
