package NikeAdminDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class NikeAdminDAO {
	
	DataSource dataSource;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public NikeAdminDAO() {
		

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			connection = dataSource.getConnection();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void shoeswrite(String TITLE, int PRICE, String BOARD, int NUM, String PIC1, String PIC2, String CONTENT, String CATEGORY) {

		try {
			String query = "insert into NIKESHOES (ITEMNUM, TITLE, PRICE, BOARD, NUM, PIC1, PIC2, CONTENT, CATEGORY) values (NIKESHOES_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, TITLE);
			preparedStatement.setInt(2, PRICE);
			preparedStatement.setString(3, BOARD);
			preparedStatement.setInt(4, NUM);
			preparedStatement.setString(5, PIC1);
			preparedStatement.setString(6, PIC2);
			preparedStatement.setString(7, CONTENT);
			preparedStatement.setString(8, CATEGORY);

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

	public ArrayList<NikeAdminDTO> list() {

		ArrayList<NikeAdminDTO> dtos = new ArrayList<NikeAdminDTO>();
		
		try {
			String query = "select ITEMNUM, TITLE, PRICE, BOARD, NUM, PIC1, PIC2, CONTENT, CATEGORY from NikeShoes";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int ITEMNUM = resultSet.getInt("ITEMNUM");
				String TITLE = resultSet.getString("TITLE");
				int PRICE = resultSet.getInt("PRICE");
				String BOARD = resultSet.getString("BOARD");
				int NUM = resultSet.getInt("NUM");
				String PIC1 = resultSet.getString("PIC1");
				String PIC2 = resultSet.getString("PIC2");
				String CONTENT = resultSet.getString("CONTENT");
				String CATEGORY = resultSet.getString("CATEGORY");
				
				System.out.println(ITEMNUM+" "+TITLE+" "+PRICE+" "+BOARD+" "+NUM+" "+PIC1+" "+PIC2+" "+CONTENT+" "+CATEGORY);
				NikeAdminDTO dto = new NikeAdminDTO(ITEMNUM, TITLE, PRICE, BOARD, NUM, PIC1, PIC2, CONTENT, CATEGORY);
				
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
	
	public ArrayList<NikeAdminDTO> listRunning() {

		ArrayList<NikeAdminDTO> dtos = new ArrayList<NikeAdminDTO>();
		
		try {
			String query = "select ITEMNUM, TITLE, PRICE, BOARD, NUM, PIC1, PIC2, CONTENT, CATEGORY from NikeShoes where NikeShoes.BOARD='MEN' and NikeShoes.CATEGORY='Running'";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int ITEMNUM = resultSet.getInt("ITEMNUM");
				String TITLE = resultSet.getString("TITLE");
				int PRICE = resultSet.getInt("PRICE");
				String BOARD = resultSet.getString("BOARD");
				int NUM = resultSet.getInt("NUM");
				String PIC1 = resultSet.getString("PIC1");
				String PIC2 = resultSet.getString("PIC2");
				String CONTENT = resultSet.getString("CONTENT");
				String CATEGORY = resultSet.getString("CATEGORY");
				
				System.out.println(ITEMNUM+" "+TITLE+" "+PRICE+" "+BOARD+" "+NUM+" "+PIC1+" "+PIC2+" "+CONTENT+" "+CATEGORY);
				NikeAdminDTO dto = new NikeAdminDTO(ITEMNUM, TITLE, PRICE, BOARD, NUM, PIC1, PIC2, CONTENT, CATEGORY);
				
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

	public ArrayList<NikeAdminDTO> listJordan() {

		ArrayList<NikeAdminDTO> dtos = new ArrayList<NikeAdminDTO>();
		
		try {
			String query = "select ITEMNUM, TITLE, PRICE, BOARD, NUM, PIC1, PIC2, CONTENT, CATEGORY from NikeShoes where NikeShoes.BOARD='MEN' and NikeShoes.CATEGORY='Jordan'";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int ITEMNUM = resultSet.getInt("ITEMNUM");
				String TITLE = resultSet.getString("TITLE");
				int PRICE = resultSet.getInt("PRICE");
				String BOARD = resultSet.getString("BOARD");
				int NUM = resultSet.getInt("NUM");
				String PIC1 = resultSet.getString("PIC1");
				String PIC2 = resultSet.getString("PIC2");
				String CONTENT = resultSet.getString("CONTENT");
				String CATEGORY = resultSet.getString("CATEGORY");
				
				System.out.println(ITEMNUM+" "+TITLE+" "+PRICE+" "+BOARD+" "+NUM+" "+PIC1+" "+PIC2+" "+CONTENT+" "+CATEGORY);
				NikeAdminDTO dto = new NikeAdminDTO(ITEMNUM, TITLE, PRICE, BOARD, NUM, PIC1, PIC2, CONTENT, CATEGORY);
				
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
	
	public ArrayList<NikeAdminDTO> listSoccer() {

		ArrayList<NikeAdminDTO> dtos = new ArrayList<NikeAdminDTO>();
		
		try {
			String query = "select ITEMNUM, TITLE, PRICE, BOARD, NUM, PIC1, PIC2, CONTENT, CATEGORY from NikeShoes where NikeShoes.BOARD='MEN' and NikeShoes.CATEGORY='Soccer'";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int ITEMNUM = resultSet.getInt("ITEMNUM");
				String TITLE = resultSet.getString("TITLE");
				int PRICE = resultSet.getInt("PRICE");
				String BOARD = resultSet.getString("BOARD");
				int NUM = resultSet.getInt("NUM");
				String PIC1 = resultSet.getString("PIC1");
				String PIC2 = resultSet.getString("PIC2");
				String CONTENT = resultSet.getString("CONTENT");
				String CATEGORY = resultSet.getString("CATEGORY");
				
				System.out.println(ITEMNUM+" "+TITLE+" "+PRICE+" "+BOARD+" "+NUM+" "+PIC1+" "+PIC2+" "+CONTENT+" "+CATEGORY);
				NikeAdminDTO dto = new NikeAdminDTO(ITEMNUM, TITLE, PRICE, BOARD, NUM, PIC1, PIC2, CONTENT, CATEGORY);
				
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
	
	public NikeAdminDTO detail(String ITEMNUM) {

		NikeAdminDTO dto = null;
		
		try {
			String query = "select * from NikeShoes where ITEMNUM = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(ITEMNUM));
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				int ITEMNUM1 = resultSet.getInt("ITEMNUM");
				String TITLE = resultSet.getString("TITLE");
				int PRICE = resultSet.getInt("PRICE");
				String BOARD = resultSet.getString("BOARD");
				int NUM = resultSet.getInt("NUM");
				String PIC1 = resultSet.getString("PIC1");
				String CONTENT = resultSet.getString("CONTENT");
				String CATEGORY = resultSet.getString("CATEGORY");
				String PIC2 = resultSet.getString("PIC2");
				
				System.out.println(ITEMNUM1+" - "+TITLE+" - "+PRICE+" - "+BOARD+" - "+NUM+" - "+PIC1+" - "+PIC2+" - "+CONTENT+" - "+CATEGORY);
				dto = new NikeAdminDTO(ITEMNUM1, TITLE, PRICE, BOARD, NUM, PIC1, PIC2, CONTENT, CATEGORY);
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
		return dto;
	}
	
}
