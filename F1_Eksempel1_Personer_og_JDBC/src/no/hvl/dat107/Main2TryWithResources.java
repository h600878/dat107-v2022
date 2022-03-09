package no.hvl.dat107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2TryWithResources {

	static final String JDBC_DRIVER = "org.postgresql.Driver";
	
//	static final String DB_URL = "jdbc:postgresql://localhost:5432/dat107v22";
//	static final String USER = "postgres";
//	static final String PASS = Passwords.LOCALHOST_PASSWORD;
	
 	static final String DB_URL = "jdbc:postgresql://ider-database.westeurope.cloudapp.azure.com:5432/lph";
	static final String USER = "h600878";
	static final String PASS = "58024961aB"; //TODO Skriv inn passord

	public static void main(String[] args) throws ClassNotFoundException {

		Class.forName(JDBC_DRIVER);

		System.out.println("Kobler til database...");

		String sql = "SELECT id, navn FROM forelesning1.person";

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String navn = rs.getString("navn");

				System.out.print("ID: " + id);
				System.out.println(", Navn: " + navn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Ferdig!");
	}

}
