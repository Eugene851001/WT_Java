package by.testing.service;

import by.testing.beans.*;

public interface ClientService {
	
	void registration(User user) throws ServiceException;
	User autorization(String login, String password) throws ServiceException;
	boolean isExists(String login, String password) throws ServiceException;
}
