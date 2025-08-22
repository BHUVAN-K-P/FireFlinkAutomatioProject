package fireflink.ninzacrm.automationframework.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import fireflink.ninzacrm.automationframework.genericUtiltiy.BaseClass;

@Listeners(fireflink.ninzacrm.automationframework.genericUtiltiy.ITestListenerImplementation.class)
public class TestNGPractice extends BaseClass {

//	@Test
//	public void sampleTest() {
//		System.out.println("Hello World");
//	}
	
	
	@Test(retryAnalyzer=fireflink.ninzacrm.automationframework.genericUtiltiy.RetryAnalyserImplementation.class)
	
	public void sample() {
		Reporter.log("Clicked on create campagin btn",true);
//		Assert.fail();
		System.out.println("sample test failing");
		Reporter.log("campaign created successfully..");
		
	}
	
}
