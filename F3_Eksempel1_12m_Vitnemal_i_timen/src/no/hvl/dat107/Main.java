package no.hvl.dat107;

import java.util.Scanner;

public class Main {

	private static final Scanner scanner = new Scanner(System.in);

	private static void pauseOgSjekkDatabasen(String prompt) {
		System.out.println(prompt);
		System.out.println("Trykk \"ENTER\" for å fortsette ...");
		scanner.nextLine();
	}
	
	public static void main(String[] args) {

		VitnemalDAO dao = new VitnemalDAO();

		//a) Søke opp vitnemålet til en gitt student.
		System.out.println(dao.hentVitnemalForStudent(123456));
		
		//b.i) Registrere en ny karakter for en gitt student 
		//		når karakter ikke finnes fra før.
		/*TODO*/
		
		//b.ii)Registrere en ny karakter for en gitt student
		//		når karakter finnes fra før.
		/*TODO*/
		
		//c) Søke opp karakteren til en gitt student i et gitt kurs.
		/*TODO*/
		
	}
}
