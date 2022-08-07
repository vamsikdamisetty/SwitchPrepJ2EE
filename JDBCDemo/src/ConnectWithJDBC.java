import java.sql.*;
public class ConnectWithJDBC {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5532/postgres";
		String uName = "postgres";
		String pass = "1234";
		String sql = "select * from sessions where session_id = 3";
		String sqlAll = "select * from sessions where session_id < 6";
		String insertQuery = "insert into student values('1','Vamsi',101)";
		String preparedInsert = "insert into student values(?,?,?)";
		
		try {
			Class.forName("org.postgresql.Driver");  //Loads the driver 
			Connection con = DriverManager.getConnection(url, uName, pass);
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			//By default rs will be pointing before first record
			rs.next();
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString("session_length"));
			
			rs = statement.executeQuery(sqlAll);
			
			while(rs.next()) {
				System.out.println("Session Data");
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString("session_length"));
				System.out.println("---------------------------------------");
			}
			
			/*
			 * Insert
			 */
			int count  = statement.executeUpdate(insertQuery);
			System.out.println("Rows Affected"+count);
			
			/*
			 * Prepared Statement
			 */
			PreparedStatement pStatement = con.prepareStatement(preparedInsert);
			pStatement.setString(1, "2");
			pStatement.setString(2, "Ravi");
			pStatement.setInt(3, 102);
			pStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
