package no.hvl.dat107;

import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static void pauseOgSjekkDatabasen(String prompt) {
		System.out.println(prompt);
		System.out.println("Trykk \"ENTER\" for å fortsette ...");
		scanner.nextLine();
	}
	
	public static void main(String[] args) {
		
		//a)    Søke opp vitnemålet til en gitt student.
		//b.i)  Registrere en ny karakter for en gitt student. Karakter finnes ikke fra før.
		//b.ii) Registrere en ny karakter for en gitt student. Karakter finnes fra før!
		//c)    Søke opp karakteren til en gitt student i et gitt kurs.
		
		//Her tester vi ut det vi lager ... :)
		
	}
}
