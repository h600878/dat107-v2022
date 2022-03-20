package no.hvl.dat107;

import java.time.LocalDate;
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
		
		//c) Søke opp karakteren til en gitt student i et gitt kurs.
		Karakter dat100kar = dao.hentKarakterForStudentIEmne(123456, "DAT102");
		System.out.println(dat100kar);
		
		//b.i) Registrere en ny karakter for en gitt student 
		//		når karakter ikke finnes fra før.
		Karakter dat107D = dao.registrerKarakterForStudent(123456, "DAT107", LocalDate.now(), 'D');
		System.out.println(dat107D);

		//b.ii)Registrere en ny karakter for en gitt student
		//		når karakter finnes fra før.
		dat107D = dao.registrerKarakterForStudent(123456, "DAT107", LocalDate.now(), 'D');
		System.out.println(dat107D);

		//c) Søke opp karakteren til en gitt student i et gitt kurs.
		Karakter dat102kar = dao.hentKarakterForStudentIEmne(123456, "DAT102");
		System.out.println(dat102kar);
	}
}





