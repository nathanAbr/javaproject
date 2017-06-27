package projetCERFA.DAO.Implements;

import java.sql.Connection;

import projetCERFA.DAO.Interface.IDAO;
import projetCERFA.Database.ConnectionFactory;

public abstract class DAO<T> implements IDAO<T>{
	protected Connection con = ConnectionFactory.getConnect(ConnectionFactory.REPERTOIRE);
}
