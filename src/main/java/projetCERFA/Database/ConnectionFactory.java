package projetCERFA.Database;

import java.sql.Connection;


public abstract class ConnectionFactory {
public static final String REPERTOIRE = "database";
	
	public static Connection getConnect(String type){
		switch(type){
			case "database" :
				Database db = new Database();
				Connection con = db.connect();
				return con;
			case "file" :
				return null;
			default :
				return null;
		}
	}
}
