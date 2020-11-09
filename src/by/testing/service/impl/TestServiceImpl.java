package by.testing.service.impl;

import by.testing.beans.*;
import by.testing.service.*;

import by.testing.dao.*;

public class TestServiceImpl implements TestService {

	@Override
	public Test[] getTestByUserId(int userId) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		TestDAO testDAO = provider.getTestDAO();
		Test[] tests = null;
		try {
			tests = testDAO.getTestsByUserID(userId);
		}
		catch(DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return tests;
	}

	@Override
	public int addTest(Test test) throws ServiceException {
		// TODO Auto-generated method stub
		int testId = -1;
		DAOProvider provider = DAOProvider.getInstance();
		TestDAO testDAO = provider.getTestDAO();
		try {
			testId = testDAO.addTest(test);
		}
		catch(DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return testId;
	}

	@Override
	public Test[] getAllTests() throws ServiceException {
		Test[] tests = null;
		DAOProvider provider = DAOProvider.getInstance();
		TestDAO testDAO = provider.getTestDAO();
		try {
			tests = testDAO.getAllTests();
		}
		catch(DAOException e){
			throw new ServiceException(e.getMessage());
		}
		return tests;
	}

}
