package by.testing.controller.command.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.testing.beans.Question;
import by.testing.beans.Test;
import by.testing.controller.command.*;
import by.testing.service.QuestionService;
import by.testing.service.ServiceException;
import by.testing.service.ServiceProvider;

public class AddQuestionCommand  implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		RequestDispatcher dispatcher;
		if(session == null) {
			dispatcher = request.getRequestDispatcher("\\index.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
		Test test = (Test)session.getAttribute("test");
		
		Map<String, String[]> parameters = request.getParameterMap();
		String questionContent = parameters.get("question_content")[0];
		
		ServiceProvider provider = ServiceProvider.getInstance();
		QuestionService questionService = provider.getQuestionService();
		
		Question question = new Question();
		question.setContent(questionContent);
		try {
			questionService.addQuestion(question, test);
		}
		catch(ServiceException e) {
			System.out.println(e.getMessage());
		}
		
		dispatcher = request.getRequestDispatcher("\\WEB-INF\\jsp\\test_constructor.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
