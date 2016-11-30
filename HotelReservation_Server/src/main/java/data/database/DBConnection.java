package data.database;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  

public class DBConnection {

	public static final String url = "jdbc:mysql://localhost:3306/HotelReservation";
	public static final String name = "com.mysql.jdbc.Driver";  
	public static final String user = "root";  
	public static final String password = "b9719971008";  
	  
	public PreparedStatement pst = null;  
	
	public static Connection getConnection(){
		Connection conn;
		try {
			Class.forName(name);
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	  
}  

