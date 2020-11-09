package by.testing.controller.command.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.testing.controller.command.*;
import by.testing.service.*;
import by.testing.beans.*;

public class AddTestCommand implements Command{

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
		
		User user = (User)session.getAttribute("user");
		
		Map<String, String[]> parameters = request.getParameterMap();
		String testName = parameters.get("test_name")[0];
		
		ServiceProvider provider = ServiceProvider.getInstance();
		TestService testService = provider.getTestService();
		
		Test test = new Test(-1, testName, 1, user.getId());
		try {
			int testId = testService.addTest(test);
			test.setId(testId);
			session.setAttribute("test", test);
			System.out.println("test id: " + test.getId());
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
