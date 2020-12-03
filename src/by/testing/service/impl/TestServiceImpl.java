package by.testing.service.impl;

import by.testing.beans.*;
import by.testing.service.*;

import by.testing.dao.*;

import org.apache.log4j.*;

public class TestServiceImpl implements TestService {

	private static Logger logger = Logger.getLogger(TestServiceImpl.class);
	
	@Override
	public Test[] getTestByUserId(int userId) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		TestDAO testDAO = provider.getTestDAO();
		Test[] tests = null;
		try {
			tests = testDAO.getTestsByUserID(userId);
		}
		catch(DAOException e) {
			logger.error("DAO exception while getting test by user id");
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
			logger.error("DAO excpetion while ");
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
			logger.error("DAO exception while getting tests");
			throw new ServiceException(e.getMessage());
		}
		return tests;
	}

	@Override
	public Test getTestById(int testId) throws ServiceException {
		Test result = null;
		DAOProvider provider =DAOProvider.getInstance();
		TestDAO testDAO = provider.getTestDAO();
		try {
			result = testDAO.getTestById(testId);
		} catch(DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return result;
	}

	@Override
	public boolean deleteTest(int testId) throws ServiceException {
		DAOProvider provider=  DAOProvider.getInstance();
		TestDAO testDAO = provider.getTestDAO();
		try {
			testDAO.deleteTest(testId);
		} catch (DAOException e) {
			logger.error("DAOException while deleting test");
			throw new ServiceException(e.getMessage());
		}
		return false;
	}

}
