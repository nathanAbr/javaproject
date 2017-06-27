package projetCERFA.Database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Database {
	
	public Connection connect(){
		
		try{
			FileInputStream file = new FileInputStream("src/main/resources/db.properties");
			Properties props = new Properties();
			try{
				props.load(file);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			file.close();
			String url = props.getProperty("jdbc.url");
			String driver = props.getProperty("jdbc.driver");
			String user = props.getProperty("jdbc.user");
			String password = props.getProperty("jdbc.password");
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
}
