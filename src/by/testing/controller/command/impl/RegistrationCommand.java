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

public class RegistrationCommand implements Command {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String[]> parameters = request.getParameterMap();
		String login = parameters.get("login")[0];
		String password = parameters.get("password")[0];
		String name = parameters.get("user_first_name")[0];
		String surname = parameters.get("user_second_name")[0];
		String userType = parameters.get("user_type")[0];
		
		ServiceProvider provider = ServiceProvider.getInstance();
		
		ClientService clientService = provider.getClientService();
		User user = new User(0, name, surname, login, password, userType);
		
		RequestDispatcher dispatcher = null;
		boolean isExists = true;
		try {
			isExists = clientService.isExists(login, password);
		}
		catch(ServiceException e) {
			System.out.println(e.getMessage());
		}
		if(isExists) {
			try {
				response.getWriter().append("This user already exists");
			}
			catch(Exception e){
				
			}
		}
		else {
			try {
				clientService.registration(user);
			}
			catch(ServiceException e) {
				System.out.println(e.getMessage());
			}
			if(user.getUserType().equals("tutor")) {
				dispatcher = request.getRequestDispatcher("\\WEB-INF\\jsp\\main_tutor.jsp");
			}
			else {
				dispatcher = request.getRequestDispatcher("\\WEB-INF\\jsp\\main_student.jsp");
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

}
