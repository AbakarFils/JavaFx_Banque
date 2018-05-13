package Banque.Dao;

import java.util.List;

import entities.Agence;

public interface IAgence {
	public boolean add(Agence a);
	public boolean update(Agence e);
	public boolean delete(int idE);
	public List<Agence> liste();
	public Agence getAgenceById(int id);
}
