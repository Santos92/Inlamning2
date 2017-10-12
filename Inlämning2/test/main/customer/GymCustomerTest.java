package main.customer;
import java.time.LocalDate;

import org.junit.Test;

import junit.framework.TestCase;

public class GymCustomerTest {
	
	GymCustomer GC = new GymCustomer("199209161111" , "Alex" , "2016-11-01");

	@Test
	public void checkPayingCustomertest() {
		TestCase.assertEquals(GC.checkPayingCustomer(), true);
		TestCase.assertTrue(GC.checkPayingCustomer() == true);
		TestCase.assertFalse(GC.checkPayingCustomer() == false);
		TestCase.assertTrue(new GymCustomer("199209161111", "Alex", "2016-10-12").checkPayingCustomer() == false);
		TestCase.assertTrue(new GymCustomer("199209161111", "Alex", LocalDate.now().minusYears(2).toString()).checkPayingCustomer() == false);
		TestCase.assertTrue(new GymCustomer("199209161111", "Alex", LocalDate.now().toString()).checkPayingCustomer() == true);

	}

}
