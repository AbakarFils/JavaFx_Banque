package Banque.Dao;

import java.sql.ResultSet;

import entities.Employe;

public class Autentification {

	public static Employe findUser(String login, String pwd) throws Exception{
		Employe user = null;
		DB db=new DB();
		try {
			String sql = "SELECT * FROM utilisateur WHERE login=? AND password=?";
			db.initPrepare(sql);
			ResultSet rs= db.executeSelect() ; ;
			if(rs.next()){
				user = new Employe();
				//user.setId(rs.getInt(1));
				user.setNom(rs.getString(2));
				user.setIdProfile(rs.getInt(3));
				user.setNumPiece(rs.getString(4));
				user.setPhoto(rs.getString("photo"));

			}
			rs.close();
		return user;
		} catch (Exception e) {
			throw e;
		}
	}
}
