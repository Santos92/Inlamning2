package main.customer;

import java.time.LocalDate;

import main.Person;

public class GymCustomer extends Person {

	private LocalDate TodaysDate = LocalDate.now(), PayMembershipDate;
	
	public GymCustomer(String personNummer, String namn, String date) {
		super(personNummer, namn);
		
		String temp[] = date.split("-");
		this.PayMembershipDate = LocalDate.of(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
		
	}
	public boolean checkPayingCustomer()
	{
		if(PayMembershipDate.isAfter( TodaysDate.minusYears(1) ) && PayMembershipDate.isBefore( TodaysDate.plusDays(1) ))
			return true;
		else
			return false;
	}
	public LocalDate getPayMembershipDate() {
		return PayMembershipDate;
	}
}
