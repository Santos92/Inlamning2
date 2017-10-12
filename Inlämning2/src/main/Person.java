package main;

public abstract class Person {

	protected String namn, personNummer;
	public Person(String personNummer, String namn)
	{
		this.namn = namn;
		this.personNummer = personNummer;
	}
	public String getNamn() {
		return namn;
	}
	public String getPersonNummer() {
		return personNummer;
	}
	public void setNamn(String namn) {
		this.namn = namn;
	}
	public void setPersonNummer(String personNummer) {
		this.personNummer = personNummer;
	}
}
