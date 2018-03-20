import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

	private static String jdbcURL = "jdbc:postgresql://localhost:5432/persondb";
	private static String user = "postgres";
	private static String password = "password";

	public static boolean isDBEmpty() {
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		boolean isEmpty = false;
      	try {
        	Class.forName("org.postgresql.Driver");
        	connection = DriverManager.getConnection(jdbcURL, user, password);
        	System.out.println("Opened database successfully!");
			statement = connection.createStatement();
	    	resultSet = statement.executeQuery("SELECT * FROM person");
	    	isEmpty = (resultSet.next() == false ? true : false);
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
 		return isEmpty;
	}


}