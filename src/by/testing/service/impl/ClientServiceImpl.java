package by.testing.service.impl;

import by.testing.service.*;
import by.testing.beans.*;
import by.testing.dao.*;

import org.apache.log4j.*;

public class ClientServiceImpl implements ClientService {
	
	private static Logger logger = Logger.getLogger(ClientServiceImpl.class);
	
	public User autorization(String login, String password) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		
		UserDAO userDAO = provider.getUserDAO();
		User user = null;
		try {
			logger.info("Try autorization");
			user = userDAO.getUser(login, password);
		}
		catch(DAOException e) {
			logger.error("DAO exception while autorization");
			throw new ServiceException(e.getMessage());
		}
		
		return user;
		
	}
	
	public void registration(User user) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		
		UserDAO userDAO = provider.getUserDAO();
		try {
			userDAO.addUser(user);
		}
		catch(DAOException e) {
			logger.error("DAO exception while registration");
			throw new ServiceException(e.getMessage());
		}
	}
	
	public boolean isExists(String login, String password) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		
		UserDAO userDAO = provider.getUserDAO();
		
		boolean result = false;
		try {
			result = userDAO.isExists(login, password);
		}
		catch(DAOException e) {
			logger.error("DAO exception while checking existing");
			throw new ServiceException(e.getMessage());
		}
		
		return result;
	}
	
}
