package by.testing.service;

import by.testing.beans.*;

public interface QuestionService {
	Question[] getQuestionsForTest(Test test) throws ServiceException;
	void addQuestion(Question question, Test test) throws ServiceException;
}
