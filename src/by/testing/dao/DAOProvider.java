package by.testing.dao;

import by.testing.dao.impl.*;

public class DAOProvider {
	
	private static DAOProvider instance = null;
	
	private UserDAO userDAO = null;
	private TestDAO testDAO = null;
	private QuestionDAO questionDAO = null;
	
	private DAOProvider() {
		userDAO = new UserDAOImpl();
		testDAO = new TestDAOImpl();
		questionDAO = new QuestionDAOImpl();
	}
	
	public static DAOProvider getInstance() {
		if(instance == null) {
			instance = new DAOProvider();
		}
		return instance;
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public TestDAO getTestDAO() {
		return testDAO;
	}
	
	public QuestionDAO getQuestionDAO() {
		return questionDAO;
	}

}
