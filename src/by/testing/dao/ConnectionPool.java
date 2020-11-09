package by.testing.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.*; 

public final class ConnectionPool {	
	
	private static ConnectionPool instance = null;
	
	private BlockingQueue<Connection> connectionQueue;
	
	private ConnectionPool() {
		ResourceBundle bundle = ResourceBundle.getBundle("resources.db");  
		String url = bundle.getString("db.url");
		String user = bundle.getString("db.user");
		String password = bundle.getString("db.password");
		int maxSize = Integer.parseInt(bundle.getString("db.poolsize"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		 
		connectionQueue = new ArrayBlockingQueue<Connection>(maxSize);
		for(int i = 0; i < maxSize; i++)
		{
			try {
				connectionQueue.add(DriverManager.getConnection(url, user, password));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static ConnectionPool getInstance() {
		if(instance == null)
		{
			instance = new ConnectionPool();
		}
		return instance;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = connectionQueue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConnection(Connection conn) {
		try {
			connectionQueue.put(conn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clear()
	{
		while(!connectionQueue.isEmpty()) {
			try {
				connectionQueue.poll().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
