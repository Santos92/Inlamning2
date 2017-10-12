package main;
import javax.swing.JOptionPane;
import main.customer.CustomerData;
import main.customer.GymCustomer;

public class BestGymEver {

	private CustomerData CD = new CustomerData();
	private String input;
	private GymCustomer member;
	
	public BestGymEver()
	{
		while(true)
		{
			input = JOptionPane.showInputDialog("Skriv in namn eller personnummer p� medlemmen");
			if(input == null)
				System.exit(0);			
			if(CD.checkMemberExist(input.trim()))
				printMember(input);
			else if(input.matches("[0-9]{10}") || input.matches("[a-�A-�]*") || input.matches("[a-�A-�]*\\s*[a-�A-�]*"))
				JOptionPane.showMessageDialog(null, "Kunden �r inte och har aldrig varit medlem h�r tidigare!");
			else
				JOptionPane.showMessageDialog(null, "Fel format p� namnet eller personnummret!");
		}
	}
	public void printMember(String input)
	{
		member = CD.getMember(input.trim());
		if(member.checkPayingCustomer())
			CD.saveCustomerVisit(member);
		else
			JOptionPane.showMessageDialog(null, "Kunden �r en f�redetta medlem och betalade senast " + member.getPayMembershipDate().toString());
	}
	public static void main(String[] args) {
		new BestGymEver();
	}
}
