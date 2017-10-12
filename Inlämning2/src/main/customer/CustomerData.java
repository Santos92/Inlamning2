package main.customer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class CustomerData {
	private File f = new File("res\\customers.txt");
	private LinkedList<GymCustomer> customers = new LinkedList<GymCustomer>();
	
	// Konstruktorn går igenom filen med medlemmar och sparar dessa i en lista
	public CustomerData()
	{
		try(Scanner scan = new Scanner(f))
		{
			while(scan.hasNext())
			{
				String temp[] = scan.nextLine().split(",");
				customers.add(new GymCustomer(temp[0].trim(), temp[1].trim(), scan.nextLine()));
			}
		}
		catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "Filen kunde ej hittas");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Ett oväntat fel inträffade... Avslutar programet!", "Fel!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// Metoden anropas när en betalande kund besöker gymet.
	// denna sparar personnummer datum och tid till en egen
	// fil för att hålla koll på besöken.
	public void saveCustomerVisit(GymCustomer GC)
	{
		File F = new File("res\\visitingCustomers.txt");
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(F, true)))){
			out.append(GC.getPersonNummer() + ", " + GC.getNamn());out.println();
			out.append("" + LocalDate.now());out.println();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Filen går ej att öppna");
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ett oväntat fel inträffade... Avslutar programet!", "Fel!", JOptionPane.ERROR_MESSAGE);
		}
		JOptionPane.showMessageDialog(null, "Kunden är en betalande medlem som betalade senast " + GC.getPayMembershipDate().toString());
	}
	
	public boolean checkMemberExist(String s)
	{
		for(GymCustomer x : customers)
		{
			if(x.getNamn().equalsIgnoreCase(s) || x.getPersonNummer().equalsIgnoreCase(s))
			{
				return true;
			}
		}
		return false;
	}
	public GymCustomer getMember(String s)
	{
		GymCustomer Member = null;
		for(GymCustomer x : customers)
			if(x.getNamn().equalsIgnoreCase(s) || x.getPersonNummer().equalsIgnoreCase(s))
			{
				Member = x;
			}
		return Member;
	}
}
