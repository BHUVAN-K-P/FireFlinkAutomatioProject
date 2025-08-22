package fireflink.ninzacrm.automationframework.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HelperAttributesOfTestNG {

//	@Test(priority=1)
//	public void insert() {
//		Assert.fail();
//		System.out.println("insert");
//	}
//	@Test
//	public void delete() {
//		System.out.println("delete");
//	}
//	
//	@Test(dependsOnMethods= {"insert"})
//	public void update() {
//		System.out.println("update");
//	}

//data provider
	
//	@DataProvider(name="customerInfo")
//	public void
//
	
	//Assertion practice
	//hard assert
	@Test
	public void sampleTest() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		Assert.assertEquals(1, 1);
		System.out.println("Step 4");
		Assert.assertEquals('a', 'a');
		System.out.println("Step 5");
	}
	
	//soft assert
	@Test
	public void softAssert() {
		 
		System.out.println("step 1");
		Assert.assertEquals(1, 0);
		System.out.println("step 2");
		SoftAssert sa=new SoftAssert();
		System.out.println("step 3");
		sa.assertEquals(1,2);
		System.out.println("step 4");
		sa.assertEquals("a", "b");
		sa.assertAll();
	}
}
	
	
