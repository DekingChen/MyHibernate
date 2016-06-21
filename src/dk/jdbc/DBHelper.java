package dk.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DBHelper {
	public static final String url = "jdbc:mysql://127.0.0.1/dataset";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "123";

	public  Connection conn = null;
	public PreparedStatement pst = null;
	public  Statement st=null;

	public DBHelper(String sql) {
		try {
			Class.forName(name);//ָ����������
			conn = DriverManager.getConnection(url, user, password);//��ȡ����
			pst = conn.prepareStatement(sql);//׼��ִ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ExecuteQuery(String sql){
		
	}
	
	public void ExecuteUpdate(String sql) throws SQLException{
		st = (Statement) conn.createStatement();
        st.executeUpdate(sql);   
	}
	
	
	

	public void close() {
		try {
			this.conn.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

