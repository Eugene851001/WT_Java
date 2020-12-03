package by.testing.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.testing.controller.command.*;
import by.testing.constants.*;

public class ChangeLocalCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		String pageUrl = null;
		if (page.equals("index"))
		{
			pageUrl = PageConstants.INDEX;
		} else if (page.equals("main_student"))
		{
			pageUrl = PageConstants.STUDENT_MAIN_PAGE;
		} else if (page.equals("main_tutor"))
		{
			pageUrl = PageConstants.TUTOR_MAIN_PAGE;
		} else {
			pageUrl = PageConstants.ERROR_PAGE;
		}
		
		HttpSession session = request.getSession(false);
		session.setAttribute("locale", request.getParameter("local"));
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher(pageUrl);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
