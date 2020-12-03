package by.testing.service;

import by.testing.beans.*;

public interface TestService {
	Test[] getTestByUserId(int userId) throws ServiceException;
	Test[] getAllTests() throws ServiceException;
	Test getTestById(int testId) throws ServiceException;
	int addTest(Test test) throws ServiceException;
	boolean deleteTest(int testId) throws ServiceException;
}
