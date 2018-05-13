package Banque.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Profile;

public class ProfileDB implements Iprofile{
	private DB db;
	private int ok;
	private  ResultSet rs;
	private boolean bol;
	public ProfileDB(){
		db =new DB();
	}
	@Override
	public int add(Profile p) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO profile VALUES(null,?)";

		try {
			db.initPrepare(sql);
			db.getPstm().setString(1, p.getLibelle());
			ok =db.executeMaj();
			rs =db.getPstm().getGeneratedKeys();
			while(rs.next())
			{
				ok =rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			bol=false;
			// TODO: handle exception
		}
		return ok;
	}

	@Override
	public boolean update(Profile p) {
		String sql="UPDATE profile SET libelle = ? WHERE idp= ?";
		bol=false;
		try {
			db.initPrepare(sql);
			db.getPstm().setString(1, p.getLibelle());
			db.getPstm().setInt(2, p.getId());
			ok =db.executeMaj();
			if(ok!=0){
				bol=true;
			}
		} catch (Exception e) {
			bol=false;
			// TODO: handle exception
		}
		return bol;
	}

	@Override
	public boolean delete(int idP) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM profile WHERE idP =?";
		bol=false;
		try {
			db.initPrepare(sql);
			db.getPstm().setInt(1, idP);
			ok =db.executeMaj();
			if(ok!=0){
				bol=true;
			}
		} catch (Exception e) {
			bol=false;
			// TODO: handle exception
		}
		return bol;
	}

	@Override
	public List<Profile> liste() {
		String sql ="select *from profile";
		List<Profile> list = new ArrayList<Profile>();
		try {
			db.initPrepare(sql);
			rs=db.executeSelect();
			while(rs.next()){
				Profile p =new Profile();
				p.setId(rs.getInt("id"));;
				p.setLibelle(rs.getString("libelle"));
				list.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public Profile getProfileById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
