package by.testing.dao;

import by.testing.beans.*;

public interface QuestionDAO {
	Question[] getQuestionsForTest(Test test) throws DAOException;
	void addQuestion(Question question, Test test) throws DAOException;
}

