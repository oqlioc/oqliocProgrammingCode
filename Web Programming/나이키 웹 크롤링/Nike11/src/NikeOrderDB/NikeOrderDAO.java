package NikeOrderDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class NikeOrderDAO {

	DataSource dataSource;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public NikeOrderDAO() {

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			connection = dataSource.getConnection();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public void order(String email, String title, int itemnum, int price, String board, int num, String category, String nikename1, String nikephone1, String nikeaddress1, String nikeaddress2, String nikemessage1) {

		try {

			String query = "insert into NIKEORDER (email, title, itemnum, price, board, num, category, nikename, nikephone, nikeaddress, nikeaddress2, nikemessage) values (?, ?, ?, ?, ?, 1, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, title);
			preparedStatement.setInt(3, itemnum);
			preparedStatement.setInt(4, price);
			preparedStatement.setString(5, board);
			preparedStatement.setString(6, category);
			preparedStatement.setString(7, nikename1);
			preparedStatement.setString(8, nikephone1);
			preparedStatement.setString(9, nikeaddress1);
			preparedStatement.setString(10, nikeaddress2);
			preparedStatement.setString(11, nikemessage1);

			int rn = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}
	
	
}
