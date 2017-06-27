package projetCERFA.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	private static String strConnect = "jdbc:mysql://localhost:3306/projetcerfa";
	private static String username = "root";
	private static String password = "";
	
	public Connection connect(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(strConnect, username, password);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
}
