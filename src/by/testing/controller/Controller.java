package by.testing.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.testing.controller.command.CommandProvider;

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
		String command = request.getParameter("command");
		if(command == null) {
			return;
		}
		CommandProvider provider = new CommandProvider();
		provider.getCommand(command).execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String[]> parameters = request.getParameterMap();
		Set<String> keys = parameters.keySet();
		Iterator<String> iterator = keys.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		String commandName = request.getParameter("command");
		CommandProvider provider = new CommandProvider();
		try {
			provider.getCommand(commandName).execute(request, response);
		}
		catch(Exception e){
			System.out.print(e.getMessage());
		}
	}

}
