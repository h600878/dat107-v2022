package no.hvl.dat107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main3UsingPersonObjects {

	static final String JDBC_DRIVER = "org.postgresql.Driver";
	
//	static final String DB_URL = "jdbc:postgresql://localhost:5432/dat107v22";
//	static final String USER = "postgres";
//	static final String PASS = Passwords.LOCALHOST_PASSWORD;
	
 	static final String DB_URL = "jdbc:postgresql://ider-database.westeurope.cloudapp.azure.com:5432/lph";
	static final String USER = "h600878";
	static final String PASS = "58024961aB"; //TODO skriv passord

	public static void main(String[] args) throws ClassNotFoundException {

		Class.forName(JDBC_DRIVER);

		System.out.println("Kobler til database...");

		String sql = "SELECT id, navn FROM forelesning1.person";

		List<Person> personer = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Person p = new Person();
				p.setId(rs.getInt("id"));
				p.setNavn(rs.getString("navn"));

				personer.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (Person p : personer) {
			System.out.print("Id: " + p.getId());
			System.out.println(", Navn: " + p.getNavn());
		}
		
		System.out.println("Ferdig!");
	}

}
