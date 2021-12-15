package uio;
import java.sql.*;
public class DbConnection {
	Connection con;
	Statement s;
	
	public DbConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pss","root","");
			s = con.createStatement();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
