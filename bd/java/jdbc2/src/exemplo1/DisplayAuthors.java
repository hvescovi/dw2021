package exemplo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayAuthors {

	public static void main(String[] args) {
		
		final String DATABASE_URL = "jdbc:mysql://localhost/books";
		final String USERNAME = "root";
		final String PASSWORD = "testando";
		
		final String SELECT_QUERY = "SELECT authorID, firstName, lastName FROM Authors";
		
		try {
			Connection con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			Statement st = con.createStatement();			
			ResultSet result = st.executeQuery(SELECT_QUERY);
			
			ResultSetMetaData md = result.getMetaData();
			int cols = md.getColumnCount();
			
			System.out.println("Autores:");
			
			for (int i = 1; i <= cols; i++) {
				System.out.printf("%-8s\t", md.getColumnName(i));
			}
			// https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax			
			/*
			 * %: especificador de formato
			 * -: alinhamento à esquerda
			 * 8: tamanho mínimo da coluna
			 * \t: tabulação após a exibição da coluna
			 */
			System.out.println();
			
			while (result.next()) {
				for (int i = 1; i <= cols; i++) {
					System.out.printf("%-8s\t", result.getObject(i));
				}
				System.out.println();
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

}
