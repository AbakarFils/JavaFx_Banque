package Banque.Dao;

import java.util.List;

import entities.Profile;

public interface Iprofile {
	public int add(Profile p);
	public boolean update(Profile p);
	public boolean delete(int idP);
	public List<Profile> liste();
	public Profile getProfileById(int id);

}
