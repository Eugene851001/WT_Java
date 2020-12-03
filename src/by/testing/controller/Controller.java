package by.testing.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.testing.controller.command.CommandProvider;

import by.testing.constants.*;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		handleRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		handleRequest(request, response);
	}
	
	protected void handleRequest(HttpServletRequest request, HttpServletResponse response)
	{
		String command = request.getParameter("command");
		if(command == null) {
			return;
		}
		CommandProvider provider = new CommandProvider();
		try {
			provider.getCommand(command).execute(request, response);
		}
		catch (Exception e)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher(PageConstants.ERROR_PAGE);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e1) {
				
				e1.printStackTrace();
			}
		}
	}

}
