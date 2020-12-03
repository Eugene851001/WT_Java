package by.testing.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.testing.controller.command.*;
import by.testing.constants.*;

public class GoToStudentMainCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher(PageConstants.STUDENT_MAIN_PAGE).forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
