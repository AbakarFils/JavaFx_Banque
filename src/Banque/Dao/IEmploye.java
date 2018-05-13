package Banque.Dao;

import java.util.List;

import entities.Employe;
import entities.Profile;

public interface IEmploye {
	public int add(Employe e);
	public boolean update(Employe e);
	public boolean delete(int idE);
	public List<Employe> liste();
	public Profile getEmployeById(int id);

}
