package by.testing.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.testing.controller.command.*;
import by.testing.service.*;
import by.testing.beans.*;
import by.testing.constants.*;

import org.apache.log4j.*;

public class DeleteTestCommand implements Command {

	private static Logger logger = Logger.getLogger(DeleteTestCommand.class);
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int testId = Integer.parseInt(request.getParameter("test_id"));
		ServiceProvider provider = ServiceProvider.getInstance();
		TestService testService = provider.getTestService();
		try {
			testService.deleteTest(testId);
		} catch (ServiceException e) {
			logger.error("Error while deleting test");
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Test[] tests = null;
		try {
			tests = testService.getTestByUserId(user.getId());
		} catch (ServiceException e) {
			logger.error("Error while getting tests");
			e.printStackTrace();
		}
		
		session.setAttribute("tests", tests);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(PageConstants.TUTOR_MAIN_PAGE);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
