package main.customer;

import static org.junit.Assert.fail;
import org.junit.Test;
import junit.framework.TestCase;

public class CustomerDataTest {

	CustomerData CD = new CustomerData();
	
	@Test
	public void CustomerDatatest() {
		try{
			new CustomerData();
		} catch (Exception e)
		{
			fail(e.getMessage());
		}
	}
	@Test
	public void checkMemberExistTest() {
		String nonExistingMember = "Alex LS";
		String ExistingMember = "Alhambra Aromes";
		TestCase.assertEquals(CD.checkMemberExist(nonExistingMember), false);
		TestCase.assertEquals(CD.checkMemberExist(ExistingMember), true);
	}
	@Test
	public void getMemberTest() {
		TestCase.assertNotNull(CD.getMember("Alhambra Aromes"));
		TestCase.assertNotNull(CD.getMember("Kadine Karlsson"));
		TestCase.assertNull(CD.getMember("Alex"));
	}
}
