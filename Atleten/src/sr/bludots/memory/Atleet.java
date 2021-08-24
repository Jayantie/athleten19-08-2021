package sr.bludots.memory;

import java.time.LocalDate;
import java.util.Random;

//
// Assignment 1: Maak een lijst van 50 atleten.
// Vul ze steeds met andere sporten, dus bijv een aantal boksers, voetballers etc ec
// Maak deze ook aan met een variabel geboortejaar (tussen 1990-2005))

//  - zoek naar alle atleten die zwemmen en druk deze dan af
//  - zoek naar alle atleten die jair heten en zwemmen en druk deze dan af
// vul de 
//  (*) zoek naar alle atleten die jonger zijn dan 20 jaar 

public class Atleet {
	
	public enum Sport { BAANWIELRENNEN, ATLETIEK, ZWEMMEN, BOKSEN, ZEILEN, VOETBAL};
	
	private String voornaam;
	
	private String achternaam;
	
	private LocalDate geboortedatum;
	
	private Sport sport;
	
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	public LocalDate getGeboortedatum() {
		return geboortedatum;
	}
	public void setGeboortedatum(LocalDate geboortedatum) {
		this.geboortedatum = geboortedatum;
	}
	public Sport getSport() {
		return sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	// bepaal de leeftijd
	public int getAge() {
		LocalDate now = LocalDate.now();
		LocalDate diff = now.minusYears(geboortedatum.getYear());
		return diff.getYear();
	}
	
	public Atleet(String voornaam, String achternaam,  Sport sport, LocalDate geboortedatum) {
		super();
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;
		this.sport = sport;
	}
	
	public static void main(String args[]) {
		Atleet atleet1 = new Atleet("Jair", "Tjon en Fa", Sport.BAANWIELRENNEN, LocalDate.of(1994,9, 1));
		System.out.println("Atleet "+ atleet1.getAchternaam() + " = " + atleet1.getAge());
		
		Random random = new Random();
		long randomGetal = random.nextLong();
		System.err.println("Willekeurig=" + randomGetal);
		
		long remain = randomGetal % 15;
		System.err.println("Remain =" + remain);
		
		
		
	}
	
	

}
