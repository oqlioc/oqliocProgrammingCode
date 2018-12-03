package NikeAddToCartDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import NikeAdminDB.NikeAdminDTO;

public class NikeAddToCartDAO {

	DataSource dataSource;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public NikeAddToCartDAO() {
		

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			connection = dataSource.getConnection();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public void addtocart(String EMAIL, String TITLE, int PRICE, String BOARD, int NUM, String PIC1, String PIC2, String CONTENT, String CATEGORY) {

		try {
			String query = "insert into NIKEADDTOCART (CARTNUM, EMAIL, TITLE, PRICE, BOARD, NUM, PIC1, PIC2, CONTENT, CATEGORY) values (NIKECARTNUM_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, EMAIL);
			preparedStatement.setString(2, TITLE);
			preparedStatement.setInt(3, PRICE);
			preparedStatement.setString(4, BOARD);
			preparedStatement.setInt(5, NUM);
			preparedStatement.setString(6, PIC1);
			preparedStatement.setString(7, PIC2);
			preparedStatement.setString(8, CONTENT);
			preparedStatement.setString(9, CATEGORY);

			preparedStatement.executeUpdate();
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
	
	public ArrayList<NikeAddToCartDTO> cartlist(String email) {

		ArrayList<NikeAddToCartDTO> dtos = new ArrayList<NikeAddToCartDTO>();
		
		try {
			String query = "select CARTNUM, EMAIL, TITLE, PRICE, BOARD, NUM, PIC1, PIC2, CONTENT, CATEGORY from NikeAddToCart where EMAIL = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int CARTNUM = resultSet.getInt("CARTNUM");
				String EMAIL = resultSet.getString("EMAIL");
				String TITLE = resultSet.getString("TITLE");
				int PRICE = resultSet.getInt("PRICE");
				String BOARD = resultSet.getString("BOARD");
				int NUM = resultSet.getInt("NUM");
				String PIC1 = resultSet.getString("PIC1");
				String PIC2 = resultSet.getString("PIC2");
				String CONTENT = resultSet.getString("CONTENT");
				String CATEGORY = resultSet.getString("CATEGORY");
				
				System.out.println(CARTNUM+" "+EMAIL+" "+TITLE+" "+PRICE+" "+BOARD+" "+NUM+" "+PIC1+" "+PIC2+" "+CONTENT+" "+CATEGORY);
				NikeAddToCartDTO dto = new NikeAddToCartDTO(CARTNUM, EMAIL, TITLE, PRICE, BOARD, NUM, PIC1, PIC2, CONTENT, CATEGORY);
				
				dtos.add(dto);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public void cartlistremove(String CARTNUM) {

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			connection = dataSource.getConnection();

			String query = "delete from NIKEADDTOCART where CARTNUM = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, CARTNUM);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
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
