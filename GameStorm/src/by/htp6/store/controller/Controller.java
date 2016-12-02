package by.htp6.store.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.htp6.store.command.Command;
import by.htp6.store.command.CommandProvider;
import by.htp6.store.command.NameParameter;
import by.htp6.store.command.exception.CommandNotFoundException;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public Controller() {
		super();
	}

    private void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	CommandProvider provider = CommandProvider.getInstatnce();
    	Command command = null;
    	String page = null;
    	String commandName = request.getParameter(NameParameter.PRM_COMMAND);
    
    	try {
			command = provider.getCommand(commandName);
			page = command.execute(request, response);
		} catch (CommandNotFoundException e) {
			e.printStackTrace();
		}
    	
    	if(page == null){
    		page = NamePage.INDEX_PAGE;
    	}
    	request.getRequestDispatcher(page).forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		proccessRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		proccessRequest(request, response);
	}

}