package sr.bludots.memory;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import sr.bludots.memory.SportAtleet.Sport;

/*
 * Assignment:
 * 
 * 1) Zorg ervoor dat de geboortedatum willekeurig is tussen 2 data 
 *    bijv atleten moeten geboren zijn tussen 1990 - 2003
 * 
 * 2) Zoek naar alle individuele sporters
 * 
 * 3) Druk af hoeveel teamsporters er in de lijst zitten
 * 
 * 4) Druk af hoeveel sporters er zijn die jarig zijn in Maart
 *
 * 5) Druk af hoeveel sporters er zijn die geboren zijn in 2000-2002
 * 
 * 6) Druk de geboortedatum af in de Europese notatie  1 January 2002  (en niet de Amerikaanse 2002-01-01)
 */


public class AtleetManager {

	public static ArrayList<SportAtleet> atletenList = new ArrayList<>();

	// zoek naar alle atleten die zwemmen en druk deze dan af
	public static void search(Sport searchSportType) {
		search("", searchSportType);
	}

	// zoek naar alle atleten die jair heten en zwemmen en druk deze dan af. Als firstName null is (negeer deze) 
	public static void search(String firstName, Sport searchSportType) {

		for (int i = 0; i < atletenList.size(); i++) {
			SportAtleet atleet = atletenList.get(i);
			if (atleet.getSport().equals(searchSportType)) {
				String voornaam = atleet.getVoornaam();
				if (firstName.equals("") || firstName.equals(voornaam)) {	
					atleet.showAtleet();
				}
			}
		}
	}
	
	public static void main(String args[]) {

		fillAtletenArray();
		
		// zoek naar alle atleten die zwemmen en druk deze dan af
		search(Sport.ZWEMMEN);
		//of
		search("", Sport.ZWEMMEN);

		// zoek naar alle atleten die jair heten en zwemmen en druk deze dan af
		search("Jair", Sport.ZWEMMEN);

		LocalDate startDatum = LocalDate.of(1999, 1, 1);
		LocalDate endDatum = LocalDate.of(2005,12, 31);
		Duration duration = Duration.between(startDatum.atStartOfDay(), endDatum.atStartOfDay());
		System.err.println(" verschil is " + duration.toDays());
		LocalDate nextDate = startDatum.plusDays(1);
		System.err.println("D1=" + startDatum + ", D2=" + nextDate);
		System.err.println("Maand van D1=" + startDatum.getMonthValue() + ", maand=" + startDatum.getMonth());
		System.err.println("Jaar van D1=" + startDatum.getYear());
		
//OPDRACHT 2. ZOEK NAAR ALLE INDIVIDUELE SPORTERS		
		ArrayList<String> unique_namen = new ArrayList<>();
		for (int i = 0; i < atletenList.size(); i++) {
			//get voornaam+achhternaam; if het geeft me 22 sporters terug
			if(unique_namen.indexOf(atletenList.get(i).getVoornaam()+atletenList.get(i).getAchternaam()) < 0) {
				unique_namen.add(atletenList.get(i).getVoornaam()+atletenList.get(i).getAchternaam());
				
				System.out.println("Alle individuele sporters=" + atletenList.get(i).getVoornaam() +" "+ atletenList.get(i).getAchternaam());
			}		
		}
		
//OPDRACHT 3) DRUK AF HOEVEEL TEAMSPORTERS ER IN DE LIJST ZITTEN
		System.out.println("Aantal unieke sporters = " + unique_namen.size());
	}
	
	public static void fillAtletenArray() {
		int maart_sporters 			= 0;
		int specifiek_jaar_sporters = 0;
		
		for (int i = 0; i < 50; i++) {
			Random random = new Random();

			String[] voornamen = { "Jair", "Lisa", "Roy", "Bob", "Jenny" };
			int chooseVoornaam = random.nextInt(voornamen.length);

			String[] achternamen = { "ling", "Ben", "Bro", "Lenny", "Rob" };
			int chooseAchternaam = random.nextInt(achternamen.length);

			int chooseSport = random.nextInt(Sport.values().length);
			
//OPDRACHT 1. ZORG ERVOOR DAT DE GEB.DATUM WILLEKEURIG IS TUSSEN 2 DATA
//BV. ATLETEN MOETEN GEBOREN ZIJN TUSSEN 1990 - 2003
			LocalDate startDatum = LocalDate.of(1990, 1, 1);
			LocalDate endDatum = LocalDate.of(2003,12, 31);
			Duration duration = Duration.between(startDatum.atStartOfDay(), endDatum.atStartOfDay());
			
			//Ber dagen van start tot enddate(2556 dgn)
			int verschil_aantaldagen = (int) duration.toDays();
			//generate een number tussen die 0 en 2565 dgn)
			int random_dagen = random.nextInt(verschil_aantaldagen);
			//de random number wordt opgeteld met die startdate
			LocalDate birthdate = startDatum.plusDays(random_dagen);
//-------------------			
			SportAtleet atleet = new SportAtleet(voornamen[chooseVoornaam], achternamen[chooseAchternaam], 
					Sport.values()[chooseSport], birthdate);

			atletenList.add(atleet);
			
//4) DRUK AF HOEVEEL SPORTERS ER ZIJN DIE JARIG ZIJN IN MAART 
			if(atletenList.get(i).getGeboorteDatum().getMonthValue() == 3) {
				maart_sporters++;
			}
			
//5) Druk af hoeveel sporters er zijn die geboren zijn in 2000-2002
			if(atletenList.get(i).getGeboorteDatum().getYear() > 2000 && 
					atletenList.get(i).getGeboorteDatum().getYear() < 2002) {
				specifiek_jaar_sporters++;
			}
			
			
		}
		
		System.out.println("Aantal sporters geboren in maart= "+maart_sporters);
		
		System.out.println("Aantal sporters geboren tussen 2000 en 2002= "+specifiek_jaar_sporters);
	}
	
	
}