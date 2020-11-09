package by.testing.service;

import by.testing.beans.*;

public interface TestService {
	Test[] getTestByUserId(int userId) throws ServiceException;
	Test[] getAllTests() throws ServiceException;
	int addTest(Test test) throws ServiceException;
}
