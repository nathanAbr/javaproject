package projetCERFA.DAO.Interface;

import java.util.List;

public interface IDAO<T> {
	public T add(T obj);
	public boolean delete(int id);
	public T update(T obj);
	public T find(int id);
	public List<T> findAll();
}
