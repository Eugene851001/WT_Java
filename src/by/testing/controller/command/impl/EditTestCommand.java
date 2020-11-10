package by.testing.controller.command.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.testing.beans.*;
import by.testing.controller.command.*;
import by.testing.service.*;

public class EditTestCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		RequestDispatcher dispatcher = null;
		if(session == null) {
			dispatcher = request.getRequestDispatcher("\\index.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String[]> parameters = request.getParameterMap();
		int testId = Integer.parseInt(parameters.get("test_id")[0]);

		ServiceProvider provider = ServiceProvider.getInstance();
		QuestionService questionService = provider.getQuestionService();
		TestService testService = provider.getTestService();
		
		Question[] questions = null;
		Test test = null;
		try {
			test = testService.getTestById(testId);
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			questions = questionService.getQuestionsForTest(test);
		} catch(ServiceException e) {
			System.out.println(e.getMessage());
		}
		
		session.setAttribute("test", test);
		session.setAttribute("questions", questions);
		dispatcher = request.getRequestDispatcher("\\WEB-INF\\jsp\\test_constructor.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
