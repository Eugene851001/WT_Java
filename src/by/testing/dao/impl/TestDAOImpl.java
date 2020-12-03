package by.testing.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import by.testing.beans.Test;
import by.testing.dao.*;

import org.apache.log4j.*;

public class TestDAOImpl implements TestDAO {

	private ConnectionPool connectionPool; 
	private static Logger logger = Logger.getLogger(TestDAOImpl.class);
	
	
	public TestDAOImpl() {
		connectionPool = ConnectionPool.getInstance();
	}

	@Override
	public Test[] getTestsByUserID(int userId) throws DAOException {
		ArrayList<Test> tests = new ArrayList<Test>();
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
	         
	         if(conn == null) {
	        	 logger.error("Can not get connection");
	        	 throw new DAOException("Connection failed...");
	         }
	         
	         Statement stm = conn.createStatement();
	         String query = "SELECT * FROM tests WHERE User_user_id=" + userId;
	         System.out.println(query);
	         stm.execute(query);
	         
	         ResultSet rs = stm.getResultSet();
	         while(rs.next()) {
	        	 Test test = new Test(rs.getInt("test_id"), rs.getString("name"), 
	        			 rs.getInt("subject_field_subject_field_id"), userId);
	        	 tests.add(test);
	        	 
	         }
		}
		catch(Exception e) {
			logger.error("Error while executin query");
			throw new DAOException("Connection failed...");
		}
		finally {
			try {
				connectionPool.closeConnection(conn);
			}
			catch(Exception ex) {
				logger.error("Exception while closing connection");
			}
		}
		Test[] result = new Test[tests.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = tests.get(i);
		}
		return result;
	}

	@Override
	public int addTest(Test test) throws DAOException {	
		Connection conn = null;
		int testId = -1;
		try {
			conn = connectionPool.getConnection();
	         
	         if(conn == null) {
	        	 logger.error("Can not get connection");
	        	 throw new DAOException("Connection failed...");
	         }
	         
	         Statement stm = conn.createStatement();
	         String query = "INSERT INTO tests VALUE(NULL, '" + test.getName() + "', " 
	        		 + test.getSubjectFieldId() + ", " + test.getUserId() + ")";
	         System.out.println(query);
	         stm.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
	         ResultSet rs = stm.getGeneratedKeys();
	         rs.next();
	         testId = rs.getInt(1);
	         System.out.println("Generated key: " + testId);
		}
		catch(Exception e) {
			logger.error("Error while executin query");
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				connectionPool.closeConnection(conn);
			}
			catch(Exception ex) {
				logger.error("Can not close connection");
			}
		}
		return testId;
	}

	@Override
	public Test[] getAllTests() throws DAOException {
		ArrayList<Test> tests = new ArrayList<Test>();
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
	         
	         if(conn == null) {
	        	 logger.error("Can not get connection");
	        	 throw new DAOException("Connection failed...");
	         }
	         
	         Statement stm = conn.createStatement();
	         String query = "SELECT * FROM tests";
	         System.out.println(query);
	         stm.execute(query);
	         
	         ResultSet rs = stm.getResultSet();
	         while(rs.next()) {
	        	 Test test = new Test();
	        	 test.setName(rs.getString("name"));
	        	 test.setId(rs.getInt("test_id"));
	        	 test.setSubjectFieldId(rs.getInt("subject_field_subject_field_id"));
	        	 test.setUserId(rs.getInt("User_user_id"));
	        	 tests.add(test); 
	         }
		}
		catch(Exception e) {
			logger.error("Error");
			throw new DAOException("Connection failed...");
		}
		finally {
			try {
				connectionPool.closeConnection(conn);
			}
			catch(Exception ex) {
				
			}
		}
		Test[] result = new Test[tests.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = tests.get(i);
		}
		return result;
	}

	@Override
	public Test getTestById(int testId) throws DAOException {
		Test result = null;
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
	         
	         if(conn == null) {
	        	 throw new DAOException("Connection failed...");
	         }
	         
	         Statement stm = conn.createStatement();
	         String query = "SELECT * FROM tests WHERE test_id=" + testId;
	         System.out.println(query);
	         stm.execute(query);
	         
	         ResultSet rs = stm.getResultSet();
	         if(rs.next()) {
		         result = new Test(rs.getInt("test_id"), rs.getString("name"), 
		        		 rs.getInt("subject_field_subject_field_id"), rs.getInt("User_user_id"));
	         }
		}
		catch(Exception e) {
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				connectionPool.closeConnection(conn);
			}
			catch(Exception ex) {
				
			}
		}
		return result;
	}

	@Override
	public boolean deleteTest(int testId) throws DAOException {
		Connection conn = null;
		try {
			conn = connectionPool.getConnection();
	         
	         if(conn == null) {
	        	 logger.error("Can not get connection");
	        	 throw new DAOException("Connection failed...");
	         }
	         
	         Statement stm = conn.createStatement();
	         String query = "DELETE FROM tests WHERE test_id=" + testId;
	         System.out.println(query);
	         stm.executeUpdate(query);
		}
		catch(Exception e) {
			logger.error("Error while executin query");
			throw new DAOException(e.getMessage());
		}
		finally {
			try {
				connectionPool.closeConnection(conn);
			}
			catch(Exception ex) {
				logger.error("Can not close connection");
			}
		}
		return true;
	}

}
