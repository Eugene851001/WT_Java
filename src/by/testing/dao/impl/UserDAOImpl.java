package by.testing.dao.impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import by.testing.beans.*;

import by.testing.dao.*;

public class UserDAOImpl implements UserDAO{
	
	int maxSize = 10;
	ConnectionPool connectionPool;
	
	public UserDAOImpl() {
		connectionPool = ConnectionPool.getInstance();		
	}
	
	public void addUser(User user) throws DAOException{
		System.out.println(user.getUserType());
		if(user.getUserType() != "tutor" && user.getUserType() != "student") {
			//throw new DAOException("Unknown user type");
		}
		
		Connection conn = null;
		try {
	         conn = connectionPool.getConnection();
	         
	         if(conn == null) {
	        	 System.out.println("Connection failed...");
	        	 return;
	         }
	         
	         Statement stm = conn.createStatement();
	         
	         String query = "INSERT INTO users VALUES(NULL" + 
	        		 ", '" + user.getName() +"', '" + user.getSurname() + "', '" + user.getLogin() + "', '"
	        		 + user.getPassword() + "', '" + user.getUserType() + "');";
	         System.out.println(query);
	         stm.execute(query);
	         
	       //  System.out.println(rs.is)
	        stm.close();
	         
		}
		catch(SQLException e) {
			throw new DAOException(e.getMessage());
		}
		catch(Exception e){
			throw new DAOException("Connection failed");
		}
		finally {
			
			if(conn != null) {
				connectionPool.closeConnection(conn);
			}
		}
	}

	@Override
	public void deleteUser(String login, String password) {

	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isExists(String login, String password) {
		Connection conn = null;
		System.out.println("login: " + login);
		System.out.println("password: " + password);
		
		boolean result = false;
		try {

	         conn = connectionPool.getConnection();
	         
	         if(conn == null) {
	        	 System.out.println("Connection failed..");
	        	 return false;
	         }
	         
	         Statement stm = conn.createStatement();
	         ResultSet rs = stm.executeQuery("SELECT * FROM users WHERE login='" 
	        		 + login + "' AND password='" + password+"'");
	         
	         int counter = 0;
	         while(rs.next()) {
	        	 counter++;
	         }
	         
	         result = counter > 0;
	         
		}
		catch(Exception e) {
			System.out.println("Connection failed...");
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
	
	public User getUser(String login, String password) {
		User user = null;
		
		Connection conn = null;
		try {
	         
	         conn = connectionPool.getConnection();
	         
	         if(conn == null) {
	        	 System.out.println("Connection failed..");
	        	 return null;
	         }
	         
	         Statement stm = conn.createStatement();
	         ResultSet rs = stm.executeQuery("SELECT * FROM users WHERE login='" 
	        		 + login + "' AND password='" + password+"'");
	         
	         if(rs.next()) {
	        	 int id = rs.getInt("user_id");
	        	 String name = rs.getString("user_first_name");
	        	 String surname = rs.getString("user_second_name");
	        	 String userType = rs.getString("type");
	        	 
	        	 user = new User(id, name, surname, login, password, userType);
	         }
	         
	         
	         stm.close();
	        
	         
		}
		catch(Exception e) {
			System.out.println("Connection failed...");
		}
		finally {
			try {
				connectionPool.closeConnection(conn);
			}
			catch(Exception ex) {
				
			}
		}
		
		return user;
	}
	
}
