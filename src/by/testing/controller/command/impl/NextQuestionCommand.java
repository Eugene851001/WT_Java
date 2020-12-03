package by.testing.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.testing.controller.command.*;
import by.testing.beans.*;
import by.testing.constants.*;

public class NextQuestionCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Question[] questions = (Question[])session.getAttribute(SessionConstants.QUESTIONS);
		int questionNumber = (int)session.getAttribute(SessionConstants.QUESTION_NUMBER) + 1;
		RequestDispatcher dispatcher = null;
		
		if (questionNumber >= questions.length)
		{
			session.setAttribute("result", "Idk, did not implement this function yet");
			session.removeAttribute(SessionConstants.QUESTION);
			session.removeAttribute(SessionConstants.QUESTION_NUMBER);
			session.removeAttribute(SessionConstants.QUESTIONS);
			dispatcher = request.getRequestDispatcher(PageConstants.TEST_RESULT_PAGE);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		session.setAttribute(SessionConstants.QUESTION, questions[questionNumber]);
		session.setAttribute(SessionConstants.QUESTION_NUMBER, questionNumber);
		
		dispatcher = request.getRequestDispatcher(PageConstants.TEST_VIEW_PAGE);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
	}

}
