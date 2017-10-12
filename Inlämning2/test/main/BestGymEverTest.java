package main;

import org.junit.Test;

import main.customer.CustomerDataTest;
import main.customer.GymCustomerTest;

public class BestGymEverTest {
	
	CustomerDataTest GCDT = new CustomerDataTest();
	GymCustomerTest GCT = new GymCustomerTest();
	
	@Test
	public void customerDataTest()
	{
		GCDT.checkMemberExistTest();
		GCDT.CustomerDatatest();
		GCDT.getMemberTest();
	}
	@Test
	public void customerTest()
	{
		GCT.checkPayingCustomertest();
	}
}
