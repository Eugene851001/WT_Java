package by.testing.dao;

import by.testing.beans.*;

public interface UserDAO {
	void addUser(User user) throws DAOException;
	void deleteUser(String login, String password) throws DAOException;
	void deleteUser(int userId) throws DAOException;
	boolean isExists(String login, String password) throws DAOException;
	User getUser(String login, String password) throws DAOException;
}
