package by.testing.controller.command.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.testing.controller.command.*;

import by.testing.service.*;
import by.testing.beans.*;

import by.testing.constants.*;

public class LoginationCommand implements Command {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String[]> parameters = request.getParameterMap();
		
		String login = parameters.get("login")[0];
		String password = parameters.get("password")[0];
		
		
		ServiceProvider provider = ServiceProvider.getInstance();
		ClientService clientService = provider.getClientService();
		TestService testService = provider.getTestService();
		
		RequestDispatcher dispatcher = null;
		User user = null;
		try { 
			user = clientService.autorization(login, password);
		}
		catch(ServiceException e) {
			System.out.println(e.getMessage());
		}
		if(user != null) {
			HttpSession session = request.getSession(true);
			Test[] tests = null;
			if(user.getUserType().equals("student")) {
				try{
					tests = testService.getAllTests();
				}
				catch(ServiceException e) {
					
				}
				session.setAttribute("tests", Arrays.asList(tests));
				dispatcher = request.getRequestDispatcher(PageConstants.STUDENT_MAIN_PAGE);
			}
			else {
				try {
					tests = testService.getTestByUserId(user.getId());
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.setAttribute("tests", Arrays.asList(tests));
				dispatcher = request.getRequestDispatcher(PageConstants.TUTOR_MAIN_PAGE);
			}
			session.setAttribute("user_type", user.getUserType());
			session.setAttribute("user", user);
			session.setAttribute("locale", "ru");
			try {
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				response.getWriter().append("User not found");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
