import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private String jdbcURL = "jdbc:postgresql://localhost:5432/persondb";
	private String user = "postgres";
	private String password = "password";
	public DBConnection() {
 		Connection connection = null;
      	try {
        	Class.forName("org.postgresql.Driver");
        	connection = DriverManager.getConnection(jdbcURL, user, password);
      	} catch (Exception ex) {
        	ex.printStackTrace();
        	System.exit(0);
      	} finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
        	}
        }
      	System.out.println("Opened database successfully!");
	}
}