package by.testing.controller.command.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.testing.beans.Question;
import by.testing.controller.command.*;

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
	
		
		Map<String, String[]> parameters = request.getParameterMap();
		String questionContent = parameters.get("question_content")[0];
		
		Question question = new Question();
		question.setContent(questionContent);
		
		Question[] questions = (Question[])session.getAttribute("questions");
		if(questions == null) {
			System.out.println("new list");
			questions = new Question[] {question};
		} else {
			System.out.println("old list");
			Question[] newQuestions = new Question[questions.length + 1];
			for(int i  = 0; i < questions.length; i++) {
				newQuestions[i] = questions[i];
			}
			newQuestions[questions.length] = question;
			questions = newQuestions;
		}
		
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
