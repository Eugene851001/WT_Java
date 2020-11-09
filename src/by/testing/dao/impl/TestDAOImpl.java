package by.testing.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import by.testing.beans.Test;
import by.testing.dao.*;

public class TestDAOImpl implements TestDAO {
	
	private ConnectionPool connectionPool; 
	
	public TestDAOImpl() {
		connectionPool = ConnectionPool.getInstance();
	}

	@Override
	public Test[] getTestsByUserID(int userId) throws DAOException {
		
		return null;
	}

	@Override
	public int addTest(Test test) throws DAOException {	
		Connection conn = null;
		int testId = -1;
		try {
			conn = connectionPool.getConnection();
	         
	         if(conn == null) {
	        	 throw new DAOException("Connection failed...");
	         }
	         
	         Statement stm = conn.createStatement();
	         String query = "INSERT INTO tests VALUE(NULL, '" + test.getName() + "', " 
	        		 + test.getSubjectFieldId() + ", " + test.getUserId() + ")";
	         System.out.println(query);
	         stm.execute(query);
	         
	         
	   /*      query = "SELECT MAX(test_id) FROM tests";
	         System.out.println(query);
	         ResultSet rs = stm.getResultSet();
	         rs.next();
	         testId = rs.getInt(1);*/
		}
		catch(Exception e) {
			throw new DAOException("Connection failed...");
		}
		finally {
			try {
				connectionPool.closeConnection(conn);
			}
			catch(Exception ex) {
				
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
	        	 tests.add(test);
	        	 
	         }
		}
		catch(Exception e) {
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

}