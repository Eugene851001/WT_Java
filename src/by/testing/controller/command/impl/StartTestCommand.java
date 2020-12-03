package by.testing.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.testing.controller.command.*;
import by.testing.beans.*;
import by.testing.service.*;
import by.testing.constants.*;

import org.apache.log4j.*;

public class StartTestCommand implements Command{

	private static Logger logger = Logger.getLogger(StartTestCommand.class);
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int testId = Integer.parseInt(request.getParameter("test_id"));
		ServiceProvider provider = ServiceProvider.getInstance();
		TestService testService = provider.getTestService();
		QuestionService questionService = provider.getQuestionService();
		Test test = null;
		try {
			 test = testService.getTestById(testId);
		} catch (ServiceException e) {
			logger.error("Service exception while getting test");
			e.printStackTrace();
		}
		
		Question[] questions = null;
		try {
			questions = questionService.getQuestionsForTest(test);
		} catch (ServiceException e) {
			logger.error("Service exception while getting questions");
			e.printStackTrace();
		}
		
		
		
		HttpSession session = request.getSession();
		session.setAttribute("test", test);
		session.setAttribute(SessionConstants.QUESTIONS, questions);
		session.setAttribute(SessionConstants.QUESTION, questions[0]);
		session.setAttribute(SessionConstants.QUESTION_NUMBER, 0);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(PageConstants.TEST_VIEW_PAGE);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
