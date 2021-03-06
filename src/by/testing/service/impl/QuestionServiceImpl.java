package by.testing.service.impl;

import by.testing.beans.Question;
import by.testing.beans.Test;
import by.testing.service.*;

import by.testing.dao.*;

import org.apache.log4j.*;

public class QuestionServiceImpl implements QuestionService{

	private static Logger logger = Logger.getLogger(QuestionServiceImpl.class);
	
	@Override
	public Question[] getQuestionsForTest(Test test) throws ServiceException {
		Question[] result = null;
		DAOProvider provider = DAOProvider.getInstance();
		QuestionDAO questionDAO = provider.getQuestionDAO();
		try {
			result = questionDAO.getQuestionsForTest(test);
		}
		catch (DAOException e){
			logger.error("DAO exception while getting question");
			throw new ServiceException(e.getMessage());
		}
		return result;
	}

	@Override
	public void addQuestion(Question question, Test test) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		QuestionDAO questionDAO = provider.getQuestionDAO();
		try {
			questionDAO.addQuestion(question, test);
		}
		catch(DAOException e) {
			logger.error("DAO exception while adding question");
			throw new ServiceException(e.getMessage());
		}
		
	}
	
}
