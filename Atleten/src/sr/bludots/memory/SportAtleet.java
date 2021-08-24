package sr.bludots.memory;

import java.time.LocalDate;
import java.util.ArrayList;

//
//Assignment 1: Maak een lijst van 50 atleten.
//Vul ze steeds met andere sporten, dus bijv een aantal boksers, voetballers etc ec
//Maak deze ook aan met een variabel geboortejaar (tussen 1990-2005))

//- zoek naar alle atleten die zwemmen en druk deze dan af
//- zoek naar alle atleten die jair heten en zwemmen en druk deze dan af
//vul de 
//(*) zoek naar alle atleten die jonger zijn dan 20 jaar 

public class SportAtleet {

	public static enum Sport {
		BAANWIELRENNEN(true), 
		ZWEMMEN(true), 
		VOETBALLEN(false), 
		BOKSEN(true), 
		ATLETIEK(true);
		
		private boolean individueel;
		
		private Sport(boolean individueel) {
			this.individueel = individueel;
		}

		public boolean isIndividueel() {
			return individueel;
		}
		
	};

	private String voornaam;
	private String achternaam;
	private Sport sport;
	private LocalDate geboorteDatum;
	
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

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public LocalDate getGeboorteDatum() {
		return geboorteDatum;
	}

	public void setGeboorteDatum(LocalDate geboorteDatum) {
		this.geboorteDatum = geboorteDatum;
	}

	public SportAtleet(String voornaam, String achternaam, Sport sport, LocalDate geboorteDatum) {
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.sport = sport;
		this.geboorteDatum = geboorteDatum;

	}

	public void showAtleet() {
		System.out.println("Voornaam	: " + getVoornaam());
		System.out.println("Achternaam	: " + getAchternaam());
		System.out.println("Sport		: " + getSport());
		System.out.println("GeboorteDatum	: " + getGeboorteDatum());
		System.out.println("Indivoidueel : "  + getSport().isIndividueel());
		System.out.println();
	}

	
}