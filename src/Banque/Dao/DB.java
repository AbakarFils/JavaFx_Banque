package Banque.Dao;
import java.sql.*;
public class DB {
	private static Connection conexion;
	private ResultSet rs;
	private PreparedStatement pstm;
	private int ok;

	private static void getConnection(){
		String url="jdbc:mysql://localhost:3306/banque";
		String user="root";
		String password="";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conexion =DriverManager.getConnection(url, user, password);
			System.out.println("ok");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void initPrepare(String sql){
			getConnection();
			try {
				if(sql.toLowerCase().startsWith("insert")){
					pstm = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				}else{
					pstm= conexion.prepareStatement(sql);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}

	public int executeMaj(){
		try {
			 ok= pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ok;
	}

	public ResultSet executeSelect(){
		try {
			rs=pstm.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
	}

	public PreparedStatement getPstm() {
		return pstm;
	}

	public void setPstm(PreparedStatement pstm) {
		this.pstm = pstm;
	}
}

