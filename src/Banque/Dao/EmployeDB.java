package Banque.Dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Agence;
import entities.Employe;
import entities.Profile;

public class EmployeDB implements IEmploye {
	private DB db;
	private int ok;
	private  ResultSet rs;
	private boolean bol;
	@Override
	public int add(Employe e) {
		String sql="INSERT INTO emplpoye VALUES(null,?,?,?,?,?,?,?,?,?)";
		bol=false;
		try {
			db.initPrepare(sql);
			db.getPstm().setInt(1,e.getIdProfile());
			db.getPstm().setInt(2,e.getIdAgence());
			db.getPstm().setString(3,e.getNom());
			db.getPstm().setString(4,e.getPrenom());
			db.getPstm().setString(5,e.getTel());
			db.getPstm().setString(6,e.getAdresse());
			db.getPstm().setString(7,e.getNumPiece());
			db.getPstm().setDate(8,(Date) e.getDateNaiss());
			db.getPstm().setString(9,e.getPhoto());
			rs =db.getPstm().getGeneratedKeys();
			while(rs.next())
			{
				ok =rs.getInt(1);
			}

		} catch (Exception r1) {
			bol=false;
		}
		return ok;
	}

	@Override
	public boolean update(Employe e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int idE) {
		String sql="DELETE FROM employe WHERE id =?";
		bol=false;
		try {
			db.initPrepare(sql);
			db.getPstm().setInt(1, idE);
			ok =db.executeMaj();
			if(ok!=0){
				bol=true;
			}
		} catch (Exception e) {
			bol=false;
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<Employe> liste() {
		String sql ="select *from Employe";
		List<Employe> list = new ArrayList<Employe>();
		try {
			db.initPrepare(sql);
			rs=db.executeSelect();
			while(rs.next()){
				Employe e =new Employe();
				e.setNumPiece(rs.getString("numPiece"));
				e.setAdresse(rs.getString("adresse"));
				e.setNom(rs.getString("nom"));
				e.setTel(rs.getString("tel"));
				e.setPrenom(rs.getString("prenom"));
				e.setDateNaiss(rs.getDate("datenaiss"));
				e.setPhoto(rs.getString("photo"));
				list.add(e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public Profile getEmployeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
