package by.testing.dao;

import by.testing.beans.*;

public interface TestDAO {
	Test[] getTestsByUserID(int userId) throws DAOException;
	Test[] getAllTests() throws DAOException;
	int addTest(Test test) throws DAOException;
}
