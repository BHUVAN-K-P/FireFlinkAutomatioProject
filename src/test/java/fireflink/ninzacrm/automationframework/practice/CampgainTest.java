package fireflink.ninzacrm.automationframework.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import fireflink.ninzacrm.automationframework.genericUtiltiy.BaseClass;
import objectrepository.CampgainPage;
import objectrepository.CreateCampgainPage;
import objectrepository.DashBoardPage;

@Listeners(fireflink.ninzacrm.automationframework.genericUtiltiy.ITestListenerImplementation.class)
public class CampgainTest extends BaseClass {

	@Test(groups="RegressionSuite")
	public void tc_001_CreateCampgain() throws EncryptedDocumentException, IOException {
		
		String NAME=fUtil.readDataFromFile("Campgain",1,2);
		String TSIZE=fUtil.readDataFromFile("Campgain",1,3);
		
		
		//DashBoardPage db=new DashBoardPage(driver);
		//db.getCampgainLink().click();
		
		CampgainPage cp=new CampgainPage(driver);
		cp.getCreateCampBtn().click();
//		
//		
		CreateCampgainPage ccp=new CreateCampgainPage(driver);
		ccp.createCampgain(NAME, TSIZE);
	}
	
	@Test
	public void samplemethod() {
		System.out.println("Regression testing");
	}
}
