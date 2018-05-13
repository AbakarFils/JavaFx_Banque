package Banque.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Agence;
import entities.Profile;

public class AgenceDB implements IAgence{
	private DB db;
	private int ok;
	private  ResultSet rs;
	private boolean bol;

	@Override
	public boolean add(Agence a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Agence e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int idE) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Agence> liste() {
		String sql ="select *from agence";
		List<Agence> list = new ArrayList<Agence>();
		try {
			db.initPrepare(sql);
			rs=db.executeSelect();
			while(rs.next()){
				Agence a =new Agence();
				a.setNumero(rs.getString("numero"));
				a.setNom(rs.getString("nom"));
				a.setTel(rs.getString("tel"));
				a.setAdress(rs.getString("adresse"));
				list.add(a);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public Agence getAgenceById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
